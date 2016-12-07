package lv.javaguru.java2.domain;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;

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

    public void validateLoginInDB(String login) {
        UserDAO userDAO = new UserDAOImpl();
        User userFromDB = userDAO.getByLogin(login);

        if (userFromDB == null) {
            throw new LoginValidationException("Login not in DB");
        }
    }
}
