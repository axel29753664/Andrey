package lv.javaguru.java2.domain.validators.betValidationRules;

import lv.javaguru.java2.database.EventDAO;
import lv.javaguru.java2.domain.Event;
import lv.javaguru.java2.servlet.dto.BetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("EventIdBetRule")
public class EventIdBetRule implements Validator {

    @Autowired
    private EventDAO eventDao;

    @Override
    public boolean supports(Class<?> aClass) {
        return BetDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        BetDTO betDTO = (BetDTO) obj;
        if (betDTO.getEventId() == null || betDTO.getEventId() <= 0){
            errors.rejectValue("eventId", "message.notChosen", "You don't choose any event.");
            return;
        }
        Event event = eventDao.getById(betDTO.getEventId());
        if (event == null){
            errors.rejectValue("eventId", "message.eventDoesNotExist", "Such event doesn't exist.");
        }
    }

}
