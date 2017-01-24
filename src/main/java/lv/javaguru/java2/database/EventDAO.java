package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Event;

import java.util.List;

public interface EventDAO extends GenericDAO<Event>{

    Event getByEventName(String name);

    List<Event> getEventsWhereWinnerStatusIsNull();

}

