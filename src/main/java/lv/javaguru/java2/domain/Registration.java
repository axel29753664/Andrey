package lv.javaguru.java2.domain;


import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;

public class Registration {
    private UserDAO userDAO;

    public Registration() {
        userDAO = new UserDAOImpl();
    }

    public void recordNewUser(User user) {
        if (!checkLoginIsInDB(user.getLogin())) {
            userDAO.create(user);
        } else {
            System.out.println("Login already taken !");
        }
    }

    private boolean checkLoginIsInDB(String login) {
        return userDAO.getByLogin(login) != null;

    }
}
