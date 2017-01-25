package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.domain.BetConditionState;
import lv.javaguru.java2.domain.Event;

import java.util.List;


public interface EventServices {
    void saveToDB(Event event);

    void delete(Long id);

    Event getByEventName(String name);

    Event getEventById(Long eventId);

    List<Event> getAllEvents();

    void updateEvent(Event event);

    List<Event> getEventsWhereWinnerStatusNotSet();

    void setEventWinner(BetConditionState winnerStatus, Long id);
}
