package lv.javaguru.java2.servlet.dto;

import lv.javaguru.java2.domain.BetConditionState;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;


public class EventDTO {
    private Long eventId;
    @NotEmpty
    private String eventName;
    @NotEmpty
    private String eventDescription;

    private boolean betSide;
    private BetConditionState winnerStatus;

    @DecimalMin("0.1")
    private double coefficient;
    private BigDecimal totalBank;

    public EventDTO() {
        this.betSide = false;
        this.totalBank = new BigDecimal(0);
        this.winnerStatus= BetConditionState.NOT_SET;
    }

    public EventDTO(String eventName, String eventDescription, double coefficient) {
        this();
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.coefficient = coefficient;
    }

    public EventDTO(Long eventId, String eventName, String eventDescription, boolean betSide, BetConditionState winnerStatus, double coefficient, BigDecimal totalBank) {
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

    public BetConditionState getWinnerStatus() {
        return winnerStatus;
    }

    public void setWinnerStatus(BetConditionState winnerStatus) {
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
}
