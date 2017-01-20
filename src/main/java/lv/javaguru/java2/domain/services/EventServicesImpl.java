package lv.javaguru.java2.domain.services;


import lv.javaguru.java2.database.EventDAO;
import lv.javaguru.java2.domain.Event;
import lv.javaguru.java2.servlet.dto.EventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServicesImpl implements EventServices {
    @Autowired
    private EventDAO eventDAO;

    @Override
    public void saveToDB(Event event) {
        eventDAO.create(event);
    }

    @Override
    public void delete(Long id) {
        eventDAO.delete(id);
    }

    @Override
    public Event getByEventName(String name) {
        return eventDAO.getByEventName(name);
    }

    @Override
    public Event getEventById(Long eventId) {
        return eventDAO.getById(eventId);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventDAO.getAll();
    }

}
