package lv.javaguru.java2.domain.validators.betValidationRules;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.servlet.dto.BetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("UserIdBetRule")
public class UserIdBetRule implements Validator {

    @Autowired
    private UserDAO userDao;

    @Override
    public boolean supports(Class<?> aClass) {
        return BetDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        BetDTO betDTO = (BetDTO) obj;
        if (betDTO.getUserId() == null || betDTO.getUserId() <= 0){
            errors.rejectValue("userId", "message.notLogin", "You are not login.");
            return;
        }
        User user = userDao.getById(betDTO.getUserId());
        if (user == null){
            errors.rejectValue("userId", "message.accountDoesNotExist", "Such account does not exist.");
        }
    }

}