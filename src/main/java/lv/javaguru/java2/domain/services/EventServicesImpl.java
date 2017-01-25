package lv.javaguru.java2.domain.services;


import lv.javaguru.java2.database.EventDAO;
import lv.javaguru.java2.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventServicesImpl implements EventServices {


    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private BetService betService;

    @Autowired
    private UserService userService;

    @Autowired
    private TransferService transferService;

    @Override
    public void saveToDB(Event event) {
        eventDAO.create(event);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        betService.deleteByEventId(id);
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

    @Override
    public void updateEvent(Event event) {
        eventDAO.update(event);
    }

    @Override
    public List<Event> getEventsWhereWinnerStatusNotSet() {
        return eventDAO.getEventsWhereWinnerStatusIsNull();
    }

    @Override
    @Transactional
    public void closeEvent(BetConditionState winnerStatus, Long eventId) {
        Event event = getEventById(eventId);
        event.setWinnerStatus(winnerStatus);
        updateEvent(event);
        transferService.transferMoneyToWinners(event);

    }


}

