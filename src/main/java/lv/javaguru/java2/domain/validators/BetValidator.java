package lv.javaguru.java2.domain.validators;

import lv.javaguru.java2.servlet.dto.BetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class BetValidator {

    @Autowired
    @Qualifier("UserIdBetRule")
    public Validator userIdBetRule;

    @Autowired
    @Qualifier("EventIdBetRule")
    public Validator eventIdBetRule;

    @Autowired
    @Qualifier("BetConditionBetRule")
    public Validator betSumBetRule;

    @Autowired
    @Qualifier("BetSumBetRule")
    public Validator betConditionBetRule;

    private List<Validator> rules = new ArrayList();

    @PostConstruct
    public void init() {
        rules.add(userIdBetRule);
        rules.add(eventIdBetRule);
        rules.add(betSumBetRule);
        rules.add(betConditionBetRule);
    }

    public void validate(Object obj, Errors validResult) {
        BetDTO betDTO = (BetDTO) obj;
        for(Validator rule : rules) {
            rule.validate(betDTO, validResult);
        }
    }

}