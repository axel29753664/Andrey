package lv.javaguru.java2.domain.betValidation;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserIdBetRule implements BetRule {

    @Autowired
    private UserDAO userDao;

    public void apply(Bet bet, List<BetValidationError> errorList) {
        if (bet.getUserId() == null){
            errorList.add(BetValidationError.NOT_LOGIN);
            return;
        }

        if (bet.getUserId() <= 0){
            errorList.add(BetValidationError.NOT_LOGIN);
            return;
        }

        User userExistence = userDao.getById(bet.getUserId());
        if (userExistence == null) {
            errorList.add(BetValidationError.ACCOUNT_DOES_NOT_EXIST);
        }
    }

}