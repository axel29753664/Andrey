package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Event;

public interface EventDAO {

    Event getById(Long eventId);

}

