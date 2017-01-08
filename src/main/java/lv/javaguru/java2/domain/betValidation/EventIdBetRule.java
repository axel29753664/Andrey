package lv.javaguru.java2.domain.betValidation;

import lv.javaguru.java2.database.EventDAO;
import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventIdBetRule implements BetRule {

    @Autowired
    private EventDAO eventDao;

    public void apply(Bet bet, List<BetValidationError> errorList) {
        if (bet.getEventId() == null){
            errorList.add(BetValidationError.EVENT_NOT_CHOSEN);
            return;
        }

        if (bet.getEventId() <= 0){
            errorList.add(BetValidationError.EVENT_NOT_CHOSEN);
            return;
        }

        Event eventExistence = eventDao.getById(bet.getEventId());
        if (eventExistence == null) {
            errorList.add(BetValidationError.EVENT_DOES_NOT_EXIST);
        }
    }

}
