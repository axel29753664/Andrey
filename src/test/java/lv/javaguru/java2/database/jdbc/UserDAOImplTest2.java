package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserDAOImplTest2 {
    @Autowired
    private UserDAO userDAO;

    private void compareUsers(User user, User userFromDB) {
        assertNotNull(userFromDB);
        assertEquals(user.getUserId(), userFromDB.getUserId());
        assertEquals(user.getFirstName(), userFromDB.getFirstName());
        assertEquals(user.getLastName(), userFromDB.getLastName());
        assertEquals(user.getLogin(), userFromDB.getLogin());
        assertEquals(user.getPassword(), userFromDB.getPassword());
    }

    private User recordUserToDB() {
        User user = new User("name", "lastName", "login", "password");
        userDAO.create(user);
        return user;
    }

    private List<User> initUserList() {
        List<User> userList = new ArrayList<>();
        userList.add(new User("a", "b", "c", "d"));
        userList.add(new User("e", "f", "g", "j"));
        userList.add(new User("1", "2", "3", "4"));
        return userList;
    }

//    @Before
//    public void clearUserTable() {
//        userDAO.deleteAll();
//    }

    @Test
    public void createTest() {
        User user = recordUserToDB();
        User userFromDB = userDAO.getById(user.getUserId());
        compareUsers(user, userFromDB);

    }

    @Test
    public void updateTest() {
        User user = recordUserToDB();
        user.setFirstName("newName");
        userDAO.update(user);
        User userFromDB = userDAO.getById(user.getUserId());
        compareUsers(user, userFromDB);
    }
    @Test
    public void getByIdTest() {
        User user = recordUserToDB();
        User userFromDB = userDAO.getById(user.getUserId());
        compareUsers(user, userFromDB);
    }

    @Test
    public void getByLoginTest() {
        User user = recordUserToDB();
        User userFromDB = userDAO.getByLogin(user.getLogin());
        compareUsers(user, userFromDB);
    }

    @Test
    public void getAllTest() {
        List<User> userList = initUserList();
        for (User user : userList) {
            userDAO.create(user);
        }
        List<User> userListFromDB = userDAO.getAll();
        for (int i = 0; i < userListFromDB.size(); i++) {
            compareUsers(userList.get(i), userListFromDB.get(i));
        }
    }


    @Test
    public void deleteByIdTest() {
        List<User> userList = initUserList();
        for (User user : userList) {
            userDAO.create(user);
        }
        userDAO.delete(userList.get(1).getUserId());
        userList.remove(1);
        List<User> userListFromDB = userDAO.getAll();
        for (int i = 0; i < userListFromDB.size(); i++) {
            compareUsers(userList.get(i), userListFromDB.get(i));
        }
    }
    @Test
    public void deleteByLoginTest() {
        List<User> userList = initUserList();
        for (User user : userList) {
            userDAO.create(user);
        }
        userDAO.deleteByLogin(userList.get(1).getLogin());
        userList.remove(1);
        List<User> userListFromDB = userDAO.getAll();
        for (int i = 0; i < userListFromDB.size(); i++) {
            compareUsers(userList.get(i), userListFromDB.get(i));
        }
    }
    @Test
    public void deleteAllTest(){
        List<User> userList = initUserList();
        for (User user : userList) {
            userDAO.create(user);
        }
        userDAO.deleteAll();
        userList.clear();
        List<User> userListFromDB = userDAO.getAll();
        assertEquals(userList,userListFromDB);
    }

}
