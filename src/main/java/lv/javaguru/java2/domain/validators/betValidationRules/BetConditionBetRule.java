package lv.javaguru.java2.domain.validators.betValidationRules;

import lv.javaguru.java2.database.EventDAO;
import lv.javaguru.java2.domain.BetConditionState;
import lv.javaguru.java2.domain.Event;
import lv.javaguru.java2.servlet.dto.BetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("BetConditionBetRule")
public class BetConditionBetRule implements Validator {

    @Autowired
    private EventDAO eventDao;

    @Override
    public boolean supports(Class<?> aClass) {
        return BetDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        BetDTO betDTO = (BetDTO) obj;
        if (betDTO.getBetCondition() == null || betDTO.getBetCondition() == BetConditionState.NOT_SET){
            errors.rejectValue("betCondition", "message.notChosen", "Winning condition not chosen.");
            return;
        }
        try {
            Event event = eventDao.getById(betDTO.getEventId());
            if (event.getBetSide() != betDTO.getBetCondition() && event.getBetSide() != BetConditionState.NOT_SET) {
                errors.rejectValue("betCondition", "message.incorrectBetCondition", "You can't choose this winning condition.");
                return;
            }
        } catch (IllegalArgumentException e1) {
            errors.rejectValue("betCondition", "message.insufficientFunds", "Can't check winning condition due incorrect data (You don't choose any event).");
        } catch (NullPointerException e2) {
            errors.rejectValue("betCondition", "message.insufficientFunds", "Can't check account balance due incorrect account (Such event doesn't exist).");
        }


    }

}
