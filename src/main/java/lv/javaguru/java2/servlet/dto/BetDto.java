package lv.javaguru.java2.servlet.dto;

import lv.javaguru.java2.domain.BetConditionState;
import org.hibernate.validator.constraints.NotEmpty;

import java.math.BigDecimal;

public class BetDto {

    //@NotEmpty
    private String betId;

    //@NotEmpty
    private String userId;

    //@NotEmpty
    private String eventId;

    //@NotEmpty
    private String betSum;

    private String uncoveredBetSum;

    //@NotEmpty
    private String betCondition;

    public BetDto() {
    }

    /*public BetDto(String betId) {
        this.betId = betId;
    }

    public BetDto(String userId,
                  String eventId,
                  String betSum,
                  String uncoveredBetId,
                  String betCondition) {
        this.userId = userId;
        this.eventId = eventId;
        this.betSum = betSum;
        this.betCondition = betCondition;
    }

    public BetDto(String betId,
                  String userId,
                  String eventId,
                  String betSum,
                  String uncoveredBetId,
                  String betCondition) {
        this.betId = betId;
        this.userId = userId;
        this.eventId = eventId;
        this.betSum = betSum;
        this.betCondition = betCondition;
    }*/

    public String getBetId() {
        return betId;
    }

    public void setBetId(String betId) {
        this.betId = betId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getBetSum() {
        return betSum;
    }

    public void setBetSum(String betSum) {
        this.betSum = betSum;
    }

    public String getUncoveredBetSum() {
        return uncoveredBetSum;
    }

    public void setUncoveredBetSum(String uncoveredBetSum) {
        this.uncoveredBetSum = uncoveredBetSum;
    }

    public String getBetCondition() {
        return betCondition;
    }

    public void setBetCondition(String betCondition) {
        this.betCondition = betCondition;
    }

}
