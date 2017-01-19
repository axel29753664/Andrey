package lv.javaguru.java2.domain.validators;


import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.servlet.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserDAO userDAO;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserDTO user = (UserDTO) o;

        if (userDAO.getByLogin(user.getLogin()) != null) {
            errors.rejectValue("login", "message.loginExist", "Login already taken.");

        }

    }
}
