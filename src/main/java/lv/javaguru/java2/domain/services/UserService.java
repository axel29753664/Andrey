package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.domain.Event;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.servlet.dto.UserDTO;

import java.util.List;

public interface UserService {

    User getUserByLogin(String login);

    void saveToDB(User user);

    void deleteUserById(Long id);

    List<User> getAllUsers();

}
