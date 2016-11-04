package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class UserDAOImplTest2 {
    private UserDAO userDAO = new UserDAOImpl();

    private void compareUsers(User user, User userFromDB) {
        assertNotNull(userFromDB);
        assertEquals(user.getUserId(), userFromDB.getUserId());
        assertEquals(user.getFirstName(), userFromDB.getFirstName());
        assertEquals(user.getLastName(), userFromDB.getLastName());
        assertEquals(user.getLogin(), userFromDB.getLogin());
        assertEquals(user.getPassword(), userFromDB.getPassword());
        assertEquals(user.isAdmin(), userFromDB.isAdmin());
    }

    @Before
    public void clearUserTable() {
        userDAO.deleteAll();
    }

    @Test
    public void createTest() {
        User user = new User("a", "b", "c", "d", false);
        userDAO.create(user);
        User userFromDB = userDAO.getById(user.getUserId());
        compareUsers(user, userFromDB);

    }

    @Test
    public void updateTest() {
        User user = new User("a", "b", "c", "d", false);
        userDAO.create(user);
        user.setFirstName("B");
        userDAO.update(user);
        User userFromDB = userDAO.getById(user.getUserId());
        compareUsers(user, userFromDB);
    }


}
