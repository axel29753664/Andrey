package lv.javaguru.java2.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="bets")
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="BetID")
    private Long betId;

    @Column(name="UserID", nullable = false)
    private Long userId;

    @Column(name="EventID", nullable = false)
    private Long eventId;

    @Column(name="BetSum", nullable = false)
    private BigDecimal betSum;

    @Enumerated(EnumType.STRING)
    @Column(name="BetCondition", nullable = false)
    private BetWinningConditionState betCondition;

    public Bet() {
    }

    public Bet(Long userId,
               Long eventId,
               BigDecimal betSum,
               BetWinningConditionState betCondition) {
        this.userId = userId;
        this.eventId = eventId;
        this.betSum = betSum;
        this.betCondition = betCondition;
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

    public BetWinningConditionState getWinningCondition() {
        return betCondition;
    }

    public void setWinningCondition(BetWinningConditionState betCondition) {
        this.betCondition = betCondition;
    }

    @Override
    public String toString() {
        return "Bet{" +
                "betId=" + betId +
                ", userId=" + userId +
                ", eventId=" + eventId +
                ", betSum=" + betSum +
                ", betCondition=" + betCondition +
                '}';
    }

}