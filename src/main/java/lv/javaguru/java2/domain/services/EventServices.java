package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.domain.Event;
import org.springframework.stereotype.Service;

@Service
public interface EventServices {
    void saveToDB(Event event);
    void delete(Long id);
    Event getByEventName(String name);
}
