package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.domain.Event;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventServices {
    void saveToDB(Event event);

    void delete(Long id);

    Event getByEventName(String name);

    Event getEventById(Long eventId);

    List<Event> getAllEvents();
}
