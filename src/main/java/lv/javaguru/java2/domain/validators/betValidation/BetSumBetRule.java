package lv.javaguru.java2.domain.validators.betValidation;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class BetSumBetRule implements BetRule {

    @Autowired
    private UserDAO userDao;

    @Override
    public void apply(Bet bet, List<BetValidationError> errorList) {

        if (bet.getBetSum() == null){
            errorList.add(BetValidationError.FIELD_WITH_BET_SUM_IS_EMPTY);
            return;
        }

        if (bet.getBetSum().compareTo(BigDecimal.ZERO) <= 0 || bet.getBetSum().scale() > 2){
            errorList.add(BetValidationError.INCORRECT_BET_SUM);
            return;
        }

        if (bet.getUserId() != null) {
            User user = userDao.getById(bet.getUserId());
            if (user.getBalance().compareTo(bet.getBetSum()) < 0) {
                errorList.add(BetValidationError.INSUFFICIENT_FUNDS);
            }
        }
    }

}
