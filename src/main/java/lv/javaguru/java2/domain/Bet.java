package lv.javaguru.java2.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="bets")
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="BetID", length = 20)
    private Long betId;

    @Column(name="UserID", length = 20, nullable = false)
    private Long userId;

    @Column(name="EventID", length = 20, nullable = false)
    private Long eventId;

    @Column(name="Bet_Sum", nullable = false)
    private BigDecimal betSum;

    @Column(name="Winning_Condition", nullable = false)
    private Boolean winningCondition;

    public Bet() {
    }

    public Bet(Long userId,
               Long eventId,
               BigDecimal betSum,
               Boolean winningCondition) {
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

    public void setWinningCondition(Boolean winingCondition) {
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

}