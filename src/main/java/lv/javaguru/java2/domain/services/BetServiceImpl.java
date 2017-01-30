package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.database.BetDAO;
import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.BetConditionState;
import lv.javaguru.java2.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

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
    public Bet getById(Long id) {
        return betDAO.getById(id);
    }


    @Override
    public List<Bet> getBetsByUserId(Long userId) {
        return betDAO.getByUserId(userId);
    }


    @Override
    public Map<Bet, Event> getAllUserBetsWithItsEvents(Long userId) {
        return geUserBetEventMap(getBetsByUserId(userId));
    }

    @Override
    public Map<Bet, Event> getActiveUserBetWithItsEventMap(Long userId) {
        return geUserBetEventMap(getUserActiveBets(userId));
    }

    private Map<Bet, Event> geUserBetEventMap(List<Bet> bets) {
        Map<Bet, Event> betEventMap = new HashMap<>();
        for (Bet bet : bets) {
            Event event = eventService.getEventById(bet.getEventId());
            betEventMap.put(bet, event);
        }
        return betEventMap;
    }

    @Override
    public List<Bet> getUserActiveBets(Long userId) {
        return betDAO.getUserBetsByEventStatus(userId, BetConditionState.NOT_SET);
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
        sumToCover = sumToCover.setScale(5, BigDecimal.ROUND_UP);
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
            newBetUncoveredSum = betSum.subtract(oppositeBetUncoveredSum.divide(betCoefficient, 5, BigDecimal.ROUND_HALF_UP));
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