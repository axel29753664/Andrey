package lv.javaguru.java2.domain.validators.betValidationRules;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.servlet.dto.BetDTO;
import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.math.BigDecimal;

@Component("BetSumBetRule")
public class BetSumBetRule implements Validator {

    @Autowired
    private UserDAO userDao;


    @Override
    public boolean supports(Class<?> aClass) {
        return BetDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        BetDTO betDTO = (BetDTO) obj;
        if (betDTO.getBetSum() == null){
            errors.rejectValue("betSum", "message.emptyField", "Field with Your bet is empty.");
            return;
        }
        if (betDTO.getBetSum().compareTo(BigDecimal.ZERO) <= 0 || betDTO.getBetSum().scale() > 2){
            errors.rejectValue("betSum", "message.incorrectSum", "You entered incorrect sum.");
            return;
        }
        try {
            User user = userDao.getById(betDTO.getUserId());
            if (user.getBalance().compareTo(betDTO.getBetSum()) < 0) {
                errors.rejectValue("betSum", "message.insufficientFunds", "Insufficient funds.");
                return;
            }
        } catch (IllegalArgumentException e1) {
            errors.rejectValue("betSum", "message.insufficientFunds", "Can't check account balance due incorrect account (You are not login).");
        } catch (NullPointerException e2) {
            errors.rejectValue("betSum", "message.insufficientFunds", "Can't check account balance due incorrect account (Such account does not exist).");
        }
    }

}