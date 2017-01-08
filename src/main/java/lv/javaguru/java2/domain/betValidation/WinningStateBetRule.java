package lv.javaguru.java2.domain.betValidation;

import lv.javaguru.java2.domain.Bet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WinningStateBetRule implements BetRule {

    public void apply(Bet bet, List<BetValidationError> errorList) {
        if (bet.getWinningCondition() == null){
            errorList.add(BetValidationError.WINNING_CONDITION_NOT_CHOSEN);
        }
    }

}
