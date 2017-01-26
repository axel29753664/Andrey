package lv.javaguru.java2.domain.validators;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.services.UserService;
import lv.javaguru.java2.servlet.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserDTO user = (UserDTO) o;
        User userFromDB = userService.getUserByLogin(user.getLogin());

        if ((userFromDB != null)&&(!userFromDB.getUserId().equals(user.getUserId()))) {
            errors.rejectValue("login", "message.loginExist", "Login already taken.");

        }

    }
}
