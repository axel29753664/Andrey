package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.database.*;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private BetDAO betDAO;

    public List<User> getAllUsers() {
        return userDAO.getAll();
    }

    @Transactional
    public void deleteUserById(Long id) {

        deleteBetsByUserID(id);
        userDAO.delete(id);
    }

    private void deleteBetsByUserID(Long id) {
        betDAO.deleteByUserId(id);
    }


}
