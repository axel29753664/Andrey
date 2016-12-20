package lv.javaguru.java2.domain;

import java.math.BigDecimal;

public class Bet {

    private Long betId;
    private Long userId;
    private Long eventId;
    private BigDecimal betSum;
    private Boolean winningCondition;

    public Bet() {
    }

    public Bet(Long userId,
               Long eventId,
               BigDecimal betSum,
               boolean winningCondition) {
        this.userId = userId;
        this.eventId = eventId;
        this.betSum = betSum;
        this.winningCondition = winningCondition;
    }

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

    public void setBetSum(BigDecimal betSum) {
        this.betSum = betSum;
    }

    public Boolean getWinningCondition() {
        return winningCondition;
    }

    public void setWinningCondition(boolean winingCondition) {
        this.winningCondition = winingCondition;
    }

    @Override
    public String toString() {
        return "Bet{" +
                "betId=" + betId +
                ", userId=" + userId +
                ", eventId=" + eventId +
                ", betSum=" + betSum +
                ", winningChoice=" + winningCondition +
                '}';
    }

   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bet bet = (Bet) o;
        if (!betId.equals(bet.betId)) return false;
        if (!userId.equals(bet.userId)) return false;
        if (!eventId.equals(bet.eventId)) return false;
        if (!betSum.equals(bet.betSum)) return false;
        return winningCondition.equals(bet.winningCondition);

    }

    @Override
    public int hashCode() {
        int result = betId.hashCode();
        result = 31 * result + userId.hashCode();
        result = 31 * result + eventId.hashCode();
        result = 31 * result + betSum.hashCode();
        result = 31 * result + winningCondition.hashCode();
        return result;
    }*/
}
