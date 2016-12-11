package lv.javaguru.java2.domain;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginService {
    @Autowired
    private UserDAO userDAO;

    private UserLoginValidation loginValidation = new UserLoginValidation();

    public User login(String login, String password) throws LoginServiceException {
        User user = userDAO.getByLogin(login);
        if (user == null) {
            throw new LoginServiceException("Login incorrect.");
        }
        if (!user.getPassword().equals(password)) {
            throw new LoginServiceException("Password incorrect.");
        }
        return user;
    }
}
