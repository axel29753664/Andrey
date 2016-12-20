package lv.javaguru.java2.domain.betValidation;

import lv.javaguru.java2.domain.Bet;

import java.util.ArrayList;
import java.util.List;

public class BetPolicy {
    private List<BetRule> rules = new ArrayList();

    public BetPolicy() {
        rules.add(new UserIdBetRule());
        rules.add(new EventIdBetRule());
        rules.add(new BetSumBetRule());
        rules.add(new WinningStateBetRule());
    }

    public List<BetValidationError> validate(Bet bet) {
        List<BetValidationError> errors = new ArrayList();
        for(BetRule rule : rules) {
            rule.apply(bet, errors);
        }
        return errors;
    }

}
