package lv.javaguru.java2.domain;

import javax.persistence.*;
import java.text.DateFormat;
import java.util.Date;

@Entity
@Table(name="Events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="EventId")
    private Long eventId;

    @Column(name="EventName", length = 45, nullable = false)
    private String eventName;

    @Column(name="UserID", length = 20, nullable = false)
    private Long userId;

    @Column(name="CreatingDate", nullable = false)
    private Date creatingDate;

    @Column(name="FinishingDate", nullable = true)
    private Date finishingDate;

    @Column(name="EventStatus", length = 20, nullable = false)
    private EventStatusState eventStatus;

    @Column(name="EventDescription", length = 255, nullable = false)
    private String eventDescription;


    public Event() {
    }

    public Event(Long eventId,
                 String eventName,
                 Long userId,
                 Date creatingDate,
                 Date finishingDate,
                 EventStatusState eventStatus,
                 String eventDescription) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.userId = userId;
        this.creatingDate = creatingDate;
        this.finishingDate = finishingDate;
        this.eventStatus = eventStatus;
        this.eventDescription = eventDescription;
    }

    public Event(Long eventId,
                 String eventName,
                 Long userId,
                 Date creatingDate,
                 EventStatusState eventStatus,
                 String eventDescription) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.userId = userId;
        this.creatingDate = creatingDate;
        this.eventStatus = eventStatus;
        this.eventDescription = eventDescription;
    }

    public Event(String eventName,
                 Long userId,
                 EventStatusState eventStatus,
                 String eventDescription) {
        this.eventName = eventName;
        this.userId = userId;
        this.eventStatus = eventStatus;
        this.eventDescription = eventDescription;
        this.creatingDate = new Date();
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public EventStatusState getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(EventStatusState eventStatus) {
        this.eventStatus = eventStatus;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", eventName='" + eventName + '\'' +
                ", userId=" + userId +
                ", creatingDate=" + DateFormat.getDateTimeInstance().format(creatingDate) +
                ", finishingDate=" + finishingDate +
                ", eventStatus=" + eventStatus +
                ", eventDescription='" + eventDescription + '\'' +
                '}';
    }
}
