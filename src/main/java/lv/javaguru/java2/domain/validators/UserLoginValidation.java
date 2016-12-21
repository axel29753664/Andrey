package lv.javaguru.java2.domain.validators;

import lv.javaguru.java2.domain.exception.LoginValidationException;

public class UserLoginValidation {
    public void validateToNull(String login) {
        if (login == null) {
            throw new LoginValidationException("Login can't be null");
        }
    }

    public void validateToEmptyString(String login) {
        if (login.equals("")) {
            throw new LoginValidationException("Login must contains some letters");
        }
    }

}
