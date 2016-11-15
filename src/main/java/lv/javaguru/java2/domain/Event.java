package lv.javaguru.java2.domain;

public class Event {
    private long eventId;
    private String eventName;

    public Event() {
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", eventName='" + eventName + '\'' +
                '}';
    }
}
