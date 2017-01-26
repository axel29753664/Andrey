package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.domain.BetConditionState;
import lv.javaguru.java2.domain.Event;
import lv.javaguru.java2.servlet.dto.BetDTO;
import lv.javaguru.java2.servlet.dto.EventDTO;
import org.springframework.validation.BindingResult;

import java.util.List;


public interface EventServices {
    void saveToDB(Event event);

    void delete(Long id);

    Event getByEventName(String name);

    Event getEventById(Long eventId);

    List<Event> getAllEvents();

    void updateEvent(Event event);

    List<Event> getEventsWhereWinnerStatusNotSet();

    void closeEvent(BetConditionState winnerStatus, Long id);

    void createEvent(Long userId, EventDTO eventDTO, BindingResult eventErrors, BetDTO betDTO, BindingResult betErrors);
}
