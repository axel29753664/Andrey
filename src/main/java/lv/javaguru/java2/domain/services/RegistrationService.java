package lv.javaguru.java2.domain.services;


import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.exception.LoginValidationException;
import lv.javaguru.java2.domain.exception.PasswordValidationException;
import lv.javaguru.java2.domain.exception.RegistrationException;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.validators.UserLoginValidation;
import lv.javaguru.java2.domain.validators.UserPasswordValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserService userService;

    private UserLoginValidation loginValidation = new UserLoginValidation();
    private UserPasswordValidation passwordValidation = new UserPasswordValidation();

    public void createNewUser(User user) throws RegistrationException {
        try {
            loginValidation.validateToNull(user.getLogin());
            loginValidation.validateToEmptyString(user.getLogin());
            passwordValidation.validateToNull(user.getPassword());
            passwordValidation.validateToEmptyString(user.getPassword());

            if (!checkLoginIsInDB(user.getLogin())) {
                userService.saveToDB(user);
            } else {
                throw new RegistrationException("Login already taken");
            }
        } catch (LoginValidationException | PasswordValidationException e) {
            throw new RegistrationException(e.getMessage());
        }
    }

    private boolean checkLoginIsInDB(String login) {
        return userDAO.getByLogin(login) != null;

    }
}
