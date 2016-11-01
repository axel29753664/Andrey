package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.User;

import java.util.List;

public interface UserDAO {

    void create(User user);

    User getById(Long id);

    User getByLogin(String login);

    void delete(Long id);

    void update(User user);

    List<User> getAll();


}
