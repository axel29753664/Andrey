package lv.javaguru.java2.domain.betValidation;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.User;

import java.util.List;

public class UserIdBetRule implements BetRule {
    UserDAO userDao = new UserDAOImpl();

    public void apply(Bet bet, List<BetValidationError> errorList) {
        if (bet.getUserId() <= 0 || bet.getUserId().equals(null)){
            errorList.add(BetValidationError.NOT_LOGIN);
        }
        User userExistence = userDao.getById(bet.getUserId());
        if (userExistence == null) {
            errorList.add(BetValidationError.ACCOUNT_DOES_NOT_EXIST);
        }
    }

}
