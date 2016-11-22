package lv.javaguru.java2.domain;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;

public class LoginService {
    public void login(String login, String password) throws LoginServiceException {
        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.getByLogin(login);
        if (user == null) {
            throw new LoginServiceException("Login incorrect.");
        }
        if (!user.getPassword().equals(password)) {
            throw new LoginServiceException("Password incorrect.");
        }
    }
}
