package lv.javaguru.java2.domain.betValidation;

import lv.javaguru.java2.domain.Bet;

import java.math.BigDecimal;
import java.util.List;

public class BetSumBetRule implements BetRule {


    public void apply(Bet bet, List<BetValidationError> errorList) {
        if (bet.getBetSum().compareTo(BigDecimal.ZERO) <= 0 || bet.getBetSum().equals(null)){
            errorList.add(BetValidationError.INCORRECT_BET_SUM);
        }
        // Check account balance!
    }

}
