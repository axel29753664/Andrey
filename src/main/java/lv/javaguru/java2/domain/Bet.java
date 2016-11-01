package lv.javaguru.java2.domain;

import java.math.BigDecimal;

public class Bet {

    private Long betId;
    private Long userId;
    private Long eventId;
    private BigDecimal betSum;
    private Boolean winningChoice;

    public Long getBetId() {
        return betId;
    }

    public void setBetId(Long betId) {
        this.betId = betId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public BigDecimal getBetSum() {
        return betSum;
    }

    public void setBetSum(BigDecimal bidSum) {
        this.betSum = bidSum;
    }

    public Boolean getWiningChoice() {
        return winningChoice;
    }

    public void setWinningChoice(Boolean winingChoice) {
        this.winningChoice = winingChoice;
    }

}
