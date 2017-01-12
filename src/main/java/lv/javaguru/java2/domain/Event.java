package lv.javaguru.java2.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EventId")
    private Long eventId;

    @Column(name = "EventName", nullable = false)
    private String eventName;

    @Column(name = "EventDescription", nullable = false)
    private String eventDescription;

    @Column(name = "WinningCondition", nullable = false)
    private String winningCondition;

    @Column(name = "LoseCondition", nullable = false)
    private String loseCondition;

    @Column(name = "DrawCondition", nullable = false)
    private String drawCondition;

    @Enumerated(EnumType.STRING)
    @Column(name = "EventStatus", columnDefinition = "enum('ACTIVE','NOT_ACTIVE', 'FINISHED')", nullable = false)
    private EventStatusState eventStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "Winner", columnDefinition = "enum('FIRST','SECOND', 'DRAW')")
    private WinnerStatus winnerStatus;

    @Column(name = "TotalBank", nullable = false)
    private BigDecimal totalBank;

    public Event() {
        this.totalBank = new BigDecimal(0);
        this.eventStatus = EventStatusState.NOT_ACTIVE;
    }

    public Event(String eventName, String eventDescription, String winningCondition, String loseCondition, String drawCondition) {
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

    public BigDecimal getTotalBank() {
        return totalBank;
    }

    public void setTotalBank(BigDecimal totalBank) {
        this.totalBank = totalBank;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", eventName='" + eventName + '\'' +
                ", eventDescription='" + eventDescription + '\'' +
                ", winningCondition='" + winningCondition + '\'' +
                ", loseCondition='" + loseCondition + '\'' +
                ", drawCondition='" + drawCondition + '\'' +
                ", eventStatus=" + eventStatus +
                ", winnerStatus=" + winnerStatus +
                ", totalBank=" + totalBank +
                '}';
    }
}
