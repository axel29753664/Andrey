package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.domain.Event;
import lv.javaguru.java2.domain.WinnerStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public interface EventServices {
    void saveToDB(Event event);

    void delete(Long id);

    Event getByEventName(String name);

    Event getEventById(Long eventId);

    List<Event> getAllEvents();

    void updateEvent(Event event);

    List<Event> getEventsWhereWinnerStatusNotSet();

    void setEventWinner(WinnerStatus winnerStatus, Long id);
}
