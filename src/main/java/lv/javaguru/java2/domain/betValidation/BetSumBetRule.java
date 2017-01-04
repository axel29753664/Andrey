package lv.javaguru.java2.domain.betValidation;

import lv.javaguru.java2.domain.Bet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class BetSumBetRule implements BetRule {

    public void apply(Bet bet, List<BetValidationError> errorList) {
        if (bet.getBetSum() == null){
            errorList.add(BetValidationError.FIELD_WITH_BET_SUM_IS_EMPTY);
            return;
        }

        if (bet.getBetSum().compareTo(BigDecimal.ZERO) <= 0){
            errorList.add(BetValidationError.INCORRECT_BET_SUM);
            return;
        }
        // Check account balance!
    }

}
