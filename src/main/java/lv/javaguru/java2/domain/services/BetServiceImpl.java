package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.database.BetDAO;
import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.BetConditionState;
import lv.javaguru.java2.domain.Event;
import lv.javaguru.java2.domain.services.factories.CreationFactory;
import lv.javaguru.java2.servlet.dto.BetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BetServiceImpl implements BetService {

    @Autowired
    private BetDAO betDAO;

    @Autowired
    private EventServices eventService;


    @Override
    public void saveToDB(Bet bet) {
        betDAO.create(bet);
    }

    @Override
    public List<Bet> getBetsByUserId(Long userId) {
        return betDAO.getByUserId(userId);
    }

    @Override
    public List<Bet> getEventBets(Long eventId) {
        return betDAO.getByEventId(eventId);
    }

    @Override
    public Bet getEventUncoveredBet(Long id) {
        return betDAO.getUncoveredEventBetByEventId(id);
    }

    @Override
    public List<Bet> getAllBets() {
        return betDAO.getAll();
    }

    @Override
    public void deleteBetById(Long betId) {
        betDAO.delete(betId);
    }

    @Override
    public void deleteByEventId(Long id) {
        betDAO.deleteByEventId(id);
    }

    @Override
    public void updateBet(Bet bet) {
        betDAO.update(bet);
    }

    @Override
    public Set<Bet> getEventWinnersBets(Long eventId, BetConditionState state) {
        List<Bet> betList = betDAO.getByEventIdAndBetCondition(eventId, state);
        Set<Bet> betSet = new HashSet<>();
        betSet.addAll(betList);
        return betSet;
    }

    @Override
    public Bet getOppositeBet(Bet bet) {
        BetConditionState betSearchingState = null;
        if (bet.getBetCondition() == BetConditionState.WIN) {
            betSearchingState = BetConditionState.LOSE;
        }
        if (bet.getBetCondition() == BetConditionState.LOSE) {
            betSearchingState = BetConditionState.WIN;
        }
        Bet oppositeBet = betDAO.getUncoveredBetByEventIdAndUncoveredSumAndState(bet.getEventId(), betSearchingState);
        return oppositeBet;
    }

    public void changeBetsUncoveredSumAndEventBetSide(Bet bet, Bet oppositeBet, Double coefficient) {
        BigDecimal betSum = bet.getBetSum();
        BigDecimal betUncoveredSum = betSum;
        BigDecimal oppositeBetUncoveredSum = oppositeBet.getUncoveredSum();
        BigDecimal betCoefficient = new BigDecimal(coefficient);

        BigDecimal sumToCover = oppositeBetUncoveredSum.subtract(betSum.multiply(betCoefficient));

        BigDecimal newOppositeBetUncoveredSum = oppositeBetUncoveredSum;
        BigDecimal newBetUncoveredSum = betUncoveredSum;

        Event event = eventService.getEventById(bet.getEventId());
        BetConditionState betSide = event.getBetSide();
        BetConditionState newBetSide = betSide;

        if (sumToCover.compareTo(BigDecimal.ZERO) > 0) {
            newOppositeBetUncoveredSum = sumToCover;
            newBetUncoveredSum = BigDecimal.ZERO;
        }

        if (sumToCover.compareTo(BigDecimal.ZERO) < 0) {
            newOppositeBetUncoveredSum = BigDecimal.ZERO;
            newBetUncoveredSum = betSum.subtract(oppositeBetUncoveredSum.divide(betCoefficient,2));
            if (betSide == BetConditionState.WIN) {
                newBetSide = BetConditionState.LOSE;
            } else {
                newBetSide = BetConditionState.WIN;
            }
        }

        if (sumToCover.compareTo(BigDecimal.ZERO) == 0) {
            newOppositeBetUncoveredSum = BigDecimal.ZERO;
            newBetUncoveredSum = BigDecimal.ZERO;
            newBetSide = BetConditionState.NOT_SET;
        }

        bet.setUncoveredSum(newBetUncoveredSum);
        oppositeBet.setUncoveredSum(newOppositeBetUncoveredSum);
        event.setBetSide(newBetSide);
        updateBet(oppositeBet);
        eventService.updateEvent(event);
    }

    public void changeEventBetSide(Bet bet) {
        Event event = eventService.getEventById(bet.getEventId());

        if (bet.getBetCondition() == BetConditionState.WIN) {
            event.setBetSide(BetConditionState.LOSE);
        } else {
            event.setBetSide(BetConditionState.WIN);
        }
        eventService.updateEvent(event);
    }

}