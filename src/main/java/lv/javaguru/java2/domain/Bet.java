package lv.javaguru.java2.domain;

import java.math.BigDecimal;

public class Bet {

    private Long betId;
    private Long userId;
    private Long eventId;
    private BigDecimal betSum;
    private boolean winningChoice;

    public Bet() {
    }

    public Bet(Long userId,
               Long eventId,
               BigDecimal betSum,
               boolean winningChoice) {
        this.userId = userId;
        this.eventId = eventId;
        this.betSum = betSum;
        this.winningChoice = winningChoice;
    }

    public long getBetId() {
        return betId;
    }

    public void setBetId(Long betId) {
        this.betId = betId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public BigDecimal getBetSum() {
        return betSum;
    }

    public void setBetSum(BigDecimal betSum) {
        this.betSum = betSum;
    }

    public boolean getWinningChoice() {
        return winningChoice;
    }

    public void setWinningChoice(boolean winingChoice) {
        this.winningChoice = winingChoice;
    }

    @Override
    public String toString() {
        return "Bet{" +
                "betId=" + betId +
                ", userId=" + userId +
                ", eventId=" + eventId +
                ", betSum=" + betSum +
                ", winningChoice=" + winningChoice +
                '}';
    }
}
