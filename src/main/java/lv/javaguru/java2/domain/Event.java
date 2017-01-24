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

    @Column(name = "BetSide", nullable = false)
    private boolean betSide;

    @Enumerated(EnumType.STRING)
    @Column(name = "Winner", columnDefinition = "enum('WIN', 'LOSE')")
    private WinnerStatus winnerStatus;

    @Column(name = "Coefficient", nullable = false)
    private double coefficient;

    @Column(name = "TotalBank", nullable = false)
    private BigDecimal totalBank;

    public Event() {
        this.totalBank = new BigDecimal(0);
        this.betSide = false;
        this.winnerStatus=WinnerStatus.NOT_SET;
    }

    public Event(String eventName, String eventDescription, double coefficient) {
        this();
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.coefficient = coefficient;
    }

    public Event(Long eventId, String eventName, String eventDescription, boolean betSide, WinnerStatus winnerStatus, double coefficient, BigDecimal totalBank) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.betSide = betSide;
        this.winnerStatus = winnerStatus;
        this.coefficient = coefficient;
        this.totalBank = totalBank;
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

    public boolean getBetSide() {
        return betSide;
    }

    public void setBetSide(boolean betSide) {
        this.betSide = betSide;
    }

    public WinnerStatus getWinnerStatus() {
        return winnerStatus;
    }

    public void setWinnerStatus(WinnerStatus winnerStatus) {
        this.winnerStatus = winnerStatus;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
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
                ", betSide=" + betSide +
                ", winnerStatus=" + winnerStatus +
                ", coefficient=" + coefficient +
                ", totalBank=" + totalBank +
                '}';
    }
}
