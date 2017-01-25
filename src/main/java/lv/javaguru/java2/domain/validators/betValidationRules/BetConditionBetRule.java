package lv.javaguru.java2.domain.validators.betValidationRules;

import lv.javaguru.java2.domain.BetConditionState;
import lv.javaguru.java2.servlet.dto.BetDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("BetConditionBetRule")
public class BetConditionBetRule implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return BetDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        BetDTO betDTO = (BetDTO) obj;
        if (betDTO.getBetCondition() == null || betDTO.getBetCondition() == BetConditionState.NOT_APPLIED){
            errors.rejectValue("betCondition", "message.notChosen", "Winning condition not chosen.");
            return;
        }
    }

}
