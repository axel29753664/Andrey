package lv.javaguru.java2.domain.services;


import lv.javaguru.java2.database.BetDAO;
import lv.javaguru.java2.database.EventDAO;
import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private EventDAO eventDAO;


    @Override
    public void createEvent(Event event) {

        eventDAO.create(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventDAO.getAll();
    }

    @Override
    public Event getEventById(Long eventId) {
        return eventDAO.getById(eventId);
    }

}
