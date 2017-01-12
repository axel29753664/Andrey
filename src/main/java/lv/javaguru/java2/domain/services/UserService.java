package lv.javaguru.java2.domain.services;


import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.Event;

import java.util.List;

public interface UserService {
    void createEvent(Event event);

    List<Event> getAllEvents();

    void makeBet(Bet bet);

}
