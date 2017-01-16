package lv.javaguru.java2.servlet.dto;

public class BetDto {

    private String betId;
    private String userId;
    private String eventId;
    private String betSum;
    private String betCondition;

    public BetDto() {
    }

    public BetDto(String userId,
                  String eventId,
                  String betSum,
                  String betCondition) {
        this.userId = userId;
        this.eventId = eventId;
        this.betSum = betSum;
        this.betCondition = betCondition;
    }

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

    public String getBetCondition() {
        return betCondition;
    }

    public void setBetCondition(String betCondition) {
        this.betCondition = betCondition;
    }

}
