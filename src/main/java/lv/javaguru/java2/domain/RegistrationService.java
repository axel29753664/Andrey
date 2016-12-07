package lv.javaguru.java2.domain;


import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;

public class RegistrationService {
    private UserDAO userDAO = new UserDAOImpl();
    private UserLoginValidation loginValidation = new UserLoginValidation();

    public void createNewUser(User user) throws RegistrationException {
        loginValidation.validateToNull(user.getLogin());
        loginValidation.validateToEmptyString(user.getLogin());

        if ((user.getPassword() == null) || (user.getPassword().equals(""))) {
            throw new RegistrationException("Password can't be null");
        }
        if (!checkLoginIsInDB(user.getLogin())) {
            userDAO.create(user);
        } else {
            throw new RegistrationException("Login already taken");
        }
    }

    private boolean checkLoginIsInDB(String login) {
        return userDAO.getByLogin(login) != null;

    }
}
