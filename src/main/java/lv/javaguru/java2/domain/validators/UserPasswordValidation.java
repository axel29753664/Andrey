package lv.javaguru.java2.domain.validators;

import lv.javaguru.java2.domain.exception.PasswordValidationException;

public class UserPasswordValidation {
    public void validateToNull(String password) {
        if (password == null) {
            throw new PasswordValidationException("Password can't be null");
        }
    }

    public void validateToEmptyString(String password) {
        if (password.equals("")) {
            throw new PasswordValidationException("Password must contains some letters");
        }
    }
}
