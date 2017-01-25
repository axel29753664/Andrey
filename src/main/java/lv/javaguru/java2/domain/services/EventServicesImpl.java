package lv.javaguru.java2.domain.services;


import lv.javaguru.java2.database.EventDAO;
import lv.javaguru.java2.domain.*;
import lv.javaguru.java2.servlet.dto.EventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EventServicesImpl implements EventServices {
    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private BetService betService;

    @Autowired
    private UserService userService;

    @Override
    public void saveToDB(Event event) {
        eventDAO.create(event);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        betService.deleteByEventId(id);
        eventDAO.delete(id);
    }

    @Override
    public Event getByEventName(String name) {
        return eventDAO.getByEventName(name);
    }

    @Override
    public Event getEventById(Long eventId) {
        return eventDAO.getById(eventId);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventDAO.getAll();
    }

    @Override
    public void updateEvent(Event event) {
        eventDAO.update(event);
    }

    @Override
    public List<Event> getEventsWhereWinnerStatusNotSet() {
        return eventDAO.getEventsWhereWinnerStatusIsNull();
    }

    @Override
    @Transactional
    public void setEventWinner(BetConditionState winnerStatus, Long eventId) {
        Event event = getEventById(eventId);
        event.setWinnerStatus(winnerStatus);
        updateEvent(event);

        Set<Bet> betSet = betService.getEventWinnersBets(eventId, event.getWinnerStatus());  //BetConditionState or WinnerState
        Bet uncoveredEventBet = betService.getUncoveredEventBet(eventId);
        BigDecimal totalBank = event.getTotalBank();

        BigDecimal userBalance = new BigDecimal(0);

        double coefficient = event.getCoefficient();
        coefficient = coefficient * 0.9;               // -10% to Totalizator
        BigDecimal coefficientAndPercent = new BigDecimal(coefficient);
        BigDecimal betSum;
        BigDecimal winSum;
        BigDecimal totalWinSum;
        //send money to winners from total bank
        //send covered bet sum
        if (uncoveredEventBet != null) {
            BigDecimal uncoveredBetSum = uncoveredEventBet.getUncoveredSum();
            User uncoveredUser = userService.getById(uncoveredEventBet.getUserId());
            if (betSet.contains(uncoveredEventBet)) {
                betSet.remove(uncoveredEventBet);
                betSum = uncoveredEventBet.getBetSum();
                BigDecimal coveredBetSum = betSum.subtract(uncoveredBetSum);
                winSum = coveredBetSum.multiply(coefficientAndPercent);
                totalWinSum = winSum.add(coveredBetSum);
                userBalance = uncoveredUser.getBalance();
                userBalance = userBalance.add(totalWinSum);
                totalBank = totalBank.subtract(totalWinSum);
                uncoveredUser.setBalance(userBalance);

            }
            //send uncovered bet sum
            userBalance = uncoveredUser.getBalance();
            userBalance = userBalance.add(uncoveredBetSum);
            totalBank = totalBank.subtract(uncoveredBetSum);
            uncoveredUser.setBalance(userBalance);
            userService.updateUser(uncoveredUser);
        }
        //send winner money
        for (Bet bet : betSet) {

            User user = userService.getById(bet.getUserId());
            userBalance = user.getBalance();
            betSum = bet.getBetSum();
            winSum = betSum.multiply(coefficientAndPercent);
            totalWinSum = winSum.add(betSum);
            userBalance = userBalance.add(totalWinSum);
            totalBank = totalBank.subtract(totalWinSum);
            user.setBalance(userBalance);

            userService.updateUser(user);
        }
        event.setTotalBank(totalBank);
    }

}
