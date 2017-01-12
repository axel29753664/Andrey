package lv.javaguru.java2.domain.services;


import lv.javaguru.java2.database.BetDAO;
import lv.javaguru.java2.database.EventDAO;
import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private EventDAO eventDAO;
    @Autowired
    private BetDAO betDAO;

    @Override
    public void createEvent(Event event) {

        eventDAO.create(event);
    }

    @Override
    public void makeBet(Bet bet) {
        betDAO.create(bet);

    }
}