package lv.javaguru.java2.domain;

import java.math.BigDecimal;

public interface BetCreator {

    Response createBet(Long userId, Long eventId, BigDecimal betSum, BetWinningConditionState winningCondition);

}
