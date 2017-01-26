package lv.javaguru.java2.domain.services;


import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.BetConditionState;
import lv.javaguru.java2.domain.Event;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;

@Service
public class TransferService {

    private final static double PERCENTS = 0.9;

    private BigDecimal uncoveredBetSum;
    private BigDecimal userBalance;
    private BigDecimal eventBank;
    private BigDecimal betSum;
    private BigDecimal winSum;
    private BigDecimal totalWinSum;
    private Set<Bet> winningBetSet;
    private Event event;
    private BigDecimal coefficientWithPercent;

    @Autowired
    private UserService userService;

    @Autowired
    private BetService betService;

    @Autowired
    private EventServices eventService;

    public void transferMoneyToWinners(Event event) {
        this.event = event;
        BetConditionState winnerStatus = event.getWinnerStatus();
        Long eventId = event.getEventId();
        winningBetSet = betService.getEventWinnersBets(eventId, winnerStatus);
        Bet uncoveredBet = betService.getEventUncoveredBet(eventId);
        coefficientWithPercent = initCoefficient();

        if (uncoveredBet != null) {
            transferUncoveredBet(uncoveredBet);
        }
        transferWinningBets();
    }

    public void transferFromUserBalanceToEventBank(Bet bet) {
        User user = userService.getById(bet.getUserId());
        Event event = eventService.getEventById(bet.getEventId());
        eventBank = event.getTotalBank();
        eventBank = eventBank.add(bet.getBetSum());
        userBalance = user.getBalance();
        userBalance = userBalance.subtract(bet.getBetSum());
        event.setTotalBank(eventBank);
        user.setBalance(userBalance);
        userService.updateUser(user);
        eventService.updateEvent(event);
    }

    private void transferWinningBets() {
        for (Bet bet : winningBetSet) {
            User user = userService.getById(bet.getUserId());
            addWinningSumToUserBalance(user, bet);
            userService.updateUser(user);
        }
    }

    private BigDecimal initCoefficient() {
        double coefficient = getWinnerCoefficient();
        coefficient = coefficientSetPercent(coefficient);
        return new BigDecimal(coefficient);
    }

    private double getWinnerCoefficient() {
        double coefficient = event.getCoefficient();
        if (event.getWinnerStatus().equals(BetConditionState.WIN)) {
            coefficient = 1 / coefficient;
        }
        return coefficient;
    }

    private double coefficientSetPercent(double coefficient) {
        return coefficient * PERCENTS;                                              // -10% to Totalizator
    }

    private void transferUncoveredBet(Bet bet) {
        User uncoveredBetUser = userService.getById(bet.getUserId());
        if (winningBetSet.contains(bet)) {
            winningBetSet.remove(bet);
            addCoveredBetSumToUserBalance(uncoveredBetUser, bet);
        }
        addUncoveredBetSumToUserBalance(uncoveredBetUser, bet);
        userService.updateUser(uncoveredBetUser);
    }

    private void addUncoveredBetSumToUserBalance(User user, Bet bet) {
        uncoveredBetSum = bet.getUncoveredSum();
        transferFromEventBankToUserBalance(user, event, uncoveredBetSum);
    }

    private void addCoveredBetSumToUserBalance(User user, Bet bet) {
        uncoveredBetSum = bet.getUncoveredSum();
        betSum = bet.getBetSum();
        BigDecimal coveredBetSum = betSum.subtract(uncoveredBetSum);

        totalWinSum = getTotalWinSum(coveredBetSum, coefficientWithPercent);
        transferFromEventBankToUserBalance(user, event, totalWinSum);
    }

    private void addWinningSumToUserBalance(User user, Bet bet) {
        betSum = bet.getBetSum();
        totalWinSum = getTotalWinSum(betSum, coefficientWithPercent);
        transferFromEventBankToUserBalance(user, event, totalWinSum);

    }

    private BigDecimal getTotalWinSum(BigDecimal betSum, BigDecimal coefficient) {
        winSum = betSum.multiply(coefficient);
        return winSum.add(betSum);
    }

    private void transferFromEventBankToUserBalance(User user, Event event, BigDecimal sum) {
        userBalance = user.getBalance();
        userBalance = userBalance.add(sum);
        eventBank = event.getTotalBank();
        eventBank = eventBank.subtract(sum);
        event.setTotalBank(eventBank);
        user.setBalance(userBalance);
    }

}
