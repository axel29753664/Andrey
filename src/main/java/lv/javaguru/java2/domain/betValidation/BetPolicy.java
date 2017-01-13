package lv.javaguru.java2.domain.betValidation;

import lv.javaguru.java2.domain.Bet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class BetPolicy {

    private List<BetRule> rules = new ArrayList();

    @Autowired
    public UserIdBetRule userIdBetRule;

    @Autowired
    public EventIdBetRule eventIdBetRule;

    @Autowired
    public BetSumBetRule betSumBetRule;

    @Autowired
    public BetConditionBetRule betConditionBetRule;

    @PostConstruct
    public void init() {
        rules.add(userIdBetRule);
        rules.add(eventIdBetRule);
        rules.add(betSumBetRule);
        rules.add(betConditionBetRule);
    }

    public List<BetValidationError> validate(Bet bet) {
        List<BetValidationError> errors = new ArrayList();
        for(BetRule rule : rules) {
            rule.apply(bet, errors);
        }
        return errors;
    }

}