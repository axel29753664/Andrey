package lv.javaguru.java2.domain.services;


import lv.javaguru.java2.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;

@Service
public class TransferService {


    @Autowired
    private UserService userService;

    @Autowired
    private BetService betService;

    @Autowired
    private EventServices eventService;

    @Autowired
    private TotalizatorBankServices bankServices;

    public void transferToTotalizatorBank(BigDecimal balance){
        bankServices.updateBalance(balance);
    }

    public void transferMoneyToWinners(Event event) {
        BetConditionState winnerStatus = event.getWinnerStatus();
        Long eventId = event.getEventId();
        Set<Bet> winningBetSet = betService.getEventWinnersBets(eventId, winnerStatus);
        Bet uncoveredBet = betService.getEventUncoveredBet(eventId);
        BigDecimal coefficientWithPercent = initCoefficient(event);

        if (uncoveredBet != null) {
            boolean isWinBet = checkUncoveredBetIsWinningBet(winningBetSet, uncoveredBet);
            transferUncoveredBet(uncoveredBet, isWinBet, coefficientWithPercent);
            winningBetSet.remove(uncoveredBet);
        }
        transferWinningBets(winningBetSet, coefficientWithPercent);
    }

    public void transferFromUserBalanceToEventBank(Bet bet) {
        User user = userService.getById(bet.getUserId());
        Event event = eventService.getEventById(bet.getEventId());
        BigDecimal eventBank = event.getTotalBank();
        eventBank = eventBank.add(bet.getBetSum());
        BigDecimal userBalance = user.getBalance();
        userBalance = userBalance.subtract(bet.getBetSum());
        event.setTotalBank(eventBank);
        user.setBalance(userBalance);
        userService.updateUser(user);
        eventService.updateEvent(event);
    }

    private void transferWinningBets(Set<Bet> winningBetSet, BigDecimal coefficient) {
        for (Bet bet : winningBetSet) {
            BigDecimal betSum = bet.getBetSum();
            BigDecimal totalWinSum = getTotalWinSum(betSum, coefficient);
            transferFromEventBankToUserBalance(bet, totalWinSum);
        }
    }

    private BigDecimal initCoefficient(Event event) {
        double coefficient = getWinnerCoefficient(event);
        coefficient = coefficientSetPercent(coefficient);
        return new BigDecimal(coefficient);
    }

    private double getWinnerCoefficient(Event event) {
        double coefficient = event.getCoefficient();
        if (event.getWinnerStatus().equals(BetConditionState.WIN)) {
            coefficient = 1 / coefficient;
        }
        return coefficient;
    }

    private double coefficientSetPercent(double coefficient) {
        return coefficient * TotalizatorBank.PERCENTS;                                              // -10% to Totalizator
    }

    private void transferUncoveredBet(Bet bet, boolean isWinBet, BigDecimal coefficient) {
        if (isWinBet) {
            BigDecimal coveredBetSum = getCoveredBetSum(bet);
            BigDecimal winSum = getTotalWinSum(coveredBetSum, coefficient);
            transferFromEventBankToUserBalance(bet, winSum);
        }
        BigDecimal uncoveredBetSum = bet.getUncoveredSum();
        transferFromEventBankToUserBalance(bet, uncoveredBetSum);
    }

    private boolean checkUncoveredBetIsWinningBet(Set<Bet> winningBetSet, Bet bet) {
        return winningBetSet.contains(bet);
    }

    private BigDecimal getCoveredBetSum(Bet bet) {
        BigDecimal uncoveredBetSum = bet.getUncoveredSum();
        BigDecimal betSum = bet.getBetSum();
        return betSum.subtract(uncoveredBetSum);
    }

    private BigDecimal getTotalWinSum(BigDecimal betSum, BigDecimal coefficient) {
        BigDecimal winSum = betSum.multiply(coefficient);
        return winSum.add(betSum);
    }

    private void transferFromEventBankToUserBalance(Bet bet, BigDecimal sum) {
        User user = userService.getById(bet.getUserId());
        Event event = eventService.getEventById(bet.getEventId());
        BigDecimal userBalance = user.getBalance();
        userBalance = userBalance.add(sum);
        BigDecimal eventBank = event.getTotalBank();
        eventBank = eventBank.subtract(sum);
        event.setTotalBank(eventBank);
        user.setBalance(userBalance);
        userService.updateUser(user);
        eventService.updateEvent(event);
    }

}