package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.exception.LoginServiceException;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.validators.UserLoginValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private UserDAO userDAO;

    private UserLoginValidation loginValidation = new UserLoginValidation();

    public User login(String login, String password) throws LoginServiceException {
        User user = userDAO.getByLogin(login);
        loginValidation.validateToNull(login);
        loginValidation.validateToEmptyString(login);
        if (user == null) {
            throw new LoginServiceException("Login incorrect.");
        }
        if (!user.getPassword().equals(password)) {
            throw new LoginServiceException("Password incorrect.");
        }
        return user;
    }
    public String getUserPage(User user){
        String url = "login";
        if ((user.getLogin()!= null) && !(user.getLogin().equals(""))){
            if (user.isAdmin()) {
                url="adminPage";
            } else {
                url = "userPage";
            }
        }
        return url;
    }
}
