package lv.javaguru.java2.domain;

import lv.javaguru.java2.database.jdbc.EventDAOImpl;

public class ValidateEventId {
    EventDAOImpl EventDao;

    public ValidateEventId() {
        EventDao = new EventDAOImpl();
    }

    public void check(long eventId) {
        if (eventId <= 0) {
            throw new ValidationIllegalStateException("You must choose event before make bet");
        }
        Event eventExistence = EventDao.getById(eventId);
        if (eventExistence == null) {
            throw new ValidationIllegalStateException("Event doesn't exist.");
        }
    }

}