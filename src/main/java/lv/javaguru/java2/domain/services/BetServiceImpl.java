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

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BetServiceImpl implements BetService {

    @Autowired
    private BetDAO betDAO;

    @Autowired
    private CreationFactory<BetDTO> betCreationFactory;

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
    public Bet getOppositeBet (Bet bet) {
        Event event = eventService.getEventById(bet.getEventId());
        BetConditionState betSearchingState = null;
        Bet oppositeBet = null;
        if (event.getBetSide() == BetConditionState.WIN) {
            betSearchingState = BetConditionState.LOSE;
        }
        if (event.getBetSide() == BetConditionState.LOSE) {
            betSearchingState = BetConditionState.WIN;
        }
        List<Bet> betList = betDAO.getByEventIdAndBetCondition(event.getEventId(), betSearchingState);    // ? getByEventIdWhereUncoveredSum >0
        for (Bet searchingBet: betList) {
            if (searchingBet.getUncoveredSum().compareTo(BigDecimal.ZERO) > 0) {
                oppositeBet = searchingBet;
            }
        }
        if (oppositeBet.getBetCondition() == bet.getBetCondition()) {
            throw new IllegalArgumentException("Incorrect data about bets condition in DB, please contact administrator.");
        }
        return oppositeBet;
    }

    public void changeBetsUncoveredSumAndEventBetSide (Bet bet, Bet oppositeBet) {
        BigDecimal betSum = bet.getBetSum();
        BigDecimal betUncoveredSum = bet.getUncoveredSum();
        BigDecimal oppositeBetUncoveredSum = oppositeBet.getUncoveredSum();
        Event event = eventService.getEventById(bet.getEventId());
        BigDecimal betCoefficient = new BigDecimal(event.getCoefficient());
        BetConditionState newBetSide = event.getBetSide();
        BigDecimal newOppositeBetUncoveredSum = oppositeBetUncoveredSum;
        BigDecimal newBetUncoveredSum = betUncoveredSum;

        if (event.getBetSide() == BetConditionState.WIN) {
            if (oppositeBetUncoveredSum.compareTo(betSum.multiply(betCoefficient)) > 0) {
                newOppositeBetUncoveredSum = oppositeBetUncoveredSum.subtract(betSum.multiply(betCoefficient));
                newBetUncoveredSum = betUncoveredSum.subtract(betSum);
            }
            if (oppositeBetUncoveredSum.compareTo(betSum.multiply(betCoefficient)) == 0) {
                newOppositeBetUncoveredSum = oppositeBetUncoveredSum.subtract(betSum.multiply(betCoefficient));
                newBetUncoveredSum = betUncoveredSum.subtract(betSum);
                newBetSide = BetConditionState.NOT_SET;
            }
            if (oppositeBetUncoveredSum.compareTo(betSum.multiply(betCoefficient)) < 0) {
                newOppositeBetUncoveredSum = oppositeBetUncoveredSum.subtract(oppositeBetUncoveredSum);
                newBetUncoveredSum = betUncoveredSum.subtract(oppositeBetUncoveredSum.divide(betCoefficient, 2));
                newBetSide = BetConditionState.LOSE;
            }
        } else {
            if (event.getBetSide() == BetConditionState.LOSE) {
                if (oppositeBetUncoveredSum.compareTo(betSum.divide(betCoefficient, 2)) > 0) {
                    newOppositeBetUncoveredSum = oppositeBetUncoveredSum.subtract(betSum.divide(betCoefficient, 2));
                    newBetUncoveredSum = betUncoveredSum.subtract(betSum);
                }
                if (oppositeBetUncoveredSum.compareTo(betSum.divide(betCoefficient, 2)) == 0) {
                    newOppositeBetUncoveredSum = oppositeBetUncoveredSum.subtract(betSum.divide(betCoefficient, 2));
                    newBetUncoveredSum = betUncoveredSum.subtract(betSum);
                    newBetSide = BetConditionState.NOT_SET;
                }
                if (oppositeBetUncoveredSum.compareTo(betSum.divide(betCoefficient, 2)) < 0) {
                    newOppositeBetUncoveredSum = oppositeBetUncoveredSum.subtract(oppositeBetUncoveredSum);
                    newBetUncoveredSum = betUncoveredSum.subtract(oppositeBetUncoveredSum.multiply(betCoefficient));
                    newBetSide = BetConditionState.WIN;
                }
            }
        }

        bet.setUncoveredSum(newBetUncoveredSum);
        oppositeBet.setUncoveredSum(newOppositeBetUncoveredSum);
        event.setBetSide(newBetSide);
        updateBet(oppositeBet);
        eventService.updateEvent(event);
    }

    @Override
    public void createFirstBet(BetDTO betDTO, BindingResult errors) {
        betCreationFactory.create(betDTO, errors);
    }

}
