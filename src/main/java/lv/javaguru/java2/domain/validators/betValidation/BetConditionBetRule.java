package lv.javaguru.java2.domain.validators.betValidation;

import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.BetConditionState;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BetConditionBetRule implements BetRule {

    @Override
    public void apply(Bet bet, List<BetValidationError> errorList) {
        if (bet.getWinningCondition() == null || bet.getWinningCondition() == BetConditionState.NOT_APPLIED){
            errorList.add(BetValidationError.WINNING_CONDITION_NOT_CHOSEN);
        }
    }

}
