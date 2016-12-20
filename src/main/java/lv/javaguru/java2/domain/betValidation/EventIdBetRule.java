package lv.javaguru.java2.domain.betValidation;

import lv.javaguru.java2.database.EventDAO;
import lv.javaguru.java2.database.jdbc.EventDAOImpl;
import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.Event;

import java.util.List;

public class EventIdBetRule implements BetRule {
    EventDAO eventDao = new EventDAOImpl();

    public void apply(Bet bet, List<BetValidationError> errorList) {
        if (bet.getEventId() <= 0 || bet.getEventId().equals(null)){
            errorList.add(BetValidationError.EVENT_NOT_CHOSEN);
        }
        Event eventExistence = eventDao.getById(bet.getEventId());
        if (eventExistence == null) {
            errorList.add(BetValidationError.EVENT_DOES_NOT_EXIST);
        }
    }

}
