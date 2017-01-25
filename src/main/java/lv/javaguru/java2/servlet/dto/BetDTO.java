package lv.javaguru.java2.servlet.dto;

import lv.javaguru.java2.domain.BetConditionState;
import java.math.BigDecimal;

public class BetDTO {

    private Long betId;

    //@NotNull(message = "You are not login")
    private Long userId;

    //@NotNull(message = "You didn't choose event")
    private Long eventId;

    //@NotNull(message = "Enter your bet")
    //@DecimalMin(value = "0.01", message = "You must bid at least 0.01")
    private BigDecimal betSum;

    private BigDecimal uncoveredSum;

    //@NotEmpty(message = "Choose winning condition")
    private BetConditionState betCondition;


    public BetDTO() {
        this.uncoveredSum = new BigDecimal(0);
    }

    public BetDTO(Long betId) {
        this.betId = betId;
    }

    public BetDTO(Long userId,
                  Long eventId,
                  BigDecimal betSum,
                  BetConditionState betCondition) {
        this();
        this.userId = userId;
        this.eventId = eventId;
        this.betSum = betSum;
        this.betCondition = betCondition;
    }

    public BetDTO(Long betId,
                  Long userId,
                  Long eventId,
                  BigDecimal betSum,
                  BigDecimal uncoveredSum,
                  BetConditionState betCondition) {
        this.betId = betId;
        this.userId = userId;
        this.eventId = eventId;
        this.betSum = betSum;
        this.uncoveredSum = uncoveredSum;
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

    public BigDecimal getUncoveredSum() {
        return uncoveredSum;
    }

    public void setUncoveredSum(BigDecimal uncoveredSum) {
        this.uncoveredSum = uncoveredSum;
    }

    public BetConditionState getBetCondition() {
        return betCondition;
    }

    public void setBetCondition(BetConditionState betCondition) {
        this.betCondition = betCondition;
    }

}