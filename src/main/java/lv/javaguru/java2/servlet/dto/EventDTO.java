package lv.javaguru.java2.servlet.dto;

import lv.javaguru.java2.domain.EventStatusState;
import lv.javaguru.java2.domain.WinnerStatus;
import org.hibernate.validator.constraints.NotEmpty;


public class EventDTO {
    private Long eventId;
    @NotEmpty
    private String eventName;
    @NotEmpty
    private String eventDescription;
    @NotEmpty
    private String winningCondition;
    @NotEmpty
    private String loseCondition;
    private String drawCondition;
    private EventStatusState eventStatus;
    private WinnerStatus winnerStatus;

    public EventDTO() {
        this.eventStatus=EventStatusState.NOT_ACTIVE;
    }

    public EventDTO(String eventName, String eventDescription, String winningCondition, String loseCondition, String drawCondition) {
        this();
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.winningCondition = winningCondition;
        this.loseCondition = loseCondition;
        this.drawCondition = drawCondition;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getWinningCondition() {
        return winningCondition;
    }

    public void setWinningCondition(String winningCondition) {
        this.winningCondition = winningCondition;
    }

    public String getLoseCondition() {
        return loseCondition;
    }

    public void setLoseCondition(String loseCondition) {
        this.loseCondition = loseCondition;
    }

    public String getDrawCondition() {
        return drawCondition;
    }

    public void setDrawCondition(String drawCondition) {
        this.drawCondition = drawCondition;
    }

    public EventStatusState getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(EventStatusState eventStatus) {
        this.eventStatus = eventStatus;
    }

    public WinnerStatus getWinnerStatus() {
        return winnerStatus;
    }

    public void setWinnerStatus(WinnerStatus winnerStatus) {
        this.winnerStatus = winnerStatus;
    }
}
