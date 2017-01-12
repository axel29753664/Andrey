package lv.javaguru.java2.domain.services;


import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.Event;

public interface UserService {
    void createEvent(Event event);
    void makeBet(Bet bet);

}
