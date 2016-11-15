package lv.javaguru.java2.domain;

import lv.javaguru.java2.database.jdbc.EventDAOImpl;

public class ValidateEventId {

    public ValidateEventId() {
    }

    public void check(Long eventId) {
        if (eventId <= 0) {
            throw new ValidationIllegalStateException("You must choose event before make bet");
        }
        EventDAOImpl EventDAO = new EventDAOImpl();
        Event eventExistence = EventDAO.getById(eventId);
        if (eventExistence == null) {
            throw new ValidationIllegalStateException("Event doesn't exist.");
        }
    }

}
