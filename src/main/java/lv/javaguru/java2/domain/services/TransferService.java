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
        return coefficient * PERCENTS;               // -10% to Totalizator
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
        userBalance = user.getBalance();
        userBalance = userBalance.add(uncoveredBetSum);
        eventBank = event.getTotalBank();
        eventBank = eventBank.subtract(uncoveredBetSum);
        event.setTotalBank(eventBank);
        user.setBalance(userBalance);
    }

    private void addCoveredBetSumToUserBalance(User user, Bet bet) {
        uncoveredBetSum = bet.getUncoveredSum();
        betSum = bet.getBetSum();
        BigDecimal coveredBetSum = betSum.subtract(uncoveredBetSum);
        winSum = coveredBetSum.multiply(coefficientWithPercent);
        totalWinSum = winSum.add(coveredBetSum);
        userBalance = user.getBalance();
        userBalance = userBalance.add(totalWinSum);
        eventBank = event.getTotalBank();
        eventBank = eventBank.subtract(totalWinSum);
        event.setTotalBank(eventBank);
        user.setBalance(userBalance);
    }

    private void addWinningSumToUserBalance(User user, Bet bet) {
        userBalance = user.getBalance();
        betSum = bet.getBetSum();
        winSum = betSum.multiply(coefficientWithPercent);
        totalWinSum = winSum.add(betSum);
        userBalance = userBalance.add(totalWinSum);
        eventBank = event.getTotalBank();
        eventBank = eventBank.subtract(totalWinSum);
        event.setTotalBank(eventBank);
        user.setBalance(userBalance);

    }
}
