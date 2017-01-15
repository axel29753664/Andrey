package lv.javaguru.java2.domain.validators.betValidation;

import lv.javaguru.java2.domain.Bet;

import java.util.List;

public interface BetRule {

    void apply(Bet bet, List<BetValidationError> errorList);

}
