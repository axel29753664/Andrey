package lv.javaguru.java2.domain;


import java.math.BigDecimal;

public interface BetCreator {

    void createBet(Long userId, Long eventId, BigDecimal betSum, BetWinningChoiceState winningChoice);

}
