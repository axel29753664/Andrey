package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private UserDAO userDAO;

    public List<User> getAllUsers() {
        return userDAO.getAll();
    }

    public void deleteUserById(Long id) {
        userDAO.delete(id);
    }
}
