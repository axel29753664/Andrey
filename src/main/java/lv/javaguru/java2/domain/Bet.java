package lv.javaguru.java2.domain;

import java.math.BigDecimal;

public class Bet {

    private long betId;
    private long userId;
    private long eventId;
    private BigDecimal betSum;
    private boolean winningChoice;

    public Bet() {
    }

    public Bet(long userId,
               long eventId,
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

    public void setBetId(long betId) {
        this.betId = betId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public BigDecimal getBetSum() {
        return betSum;
    }

    public void setBetSum(BigDecimal bidSum) {
        this.betSum = bidSum;
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
