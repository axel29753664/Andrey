package lv.javaguru.java2.domain;


import java.math.BigDecimal;

public interface BetCreator {

    void createBet(long userId, long eventId, BigDecimal betSum, BetWinningChoiceState winningChoice);

}
