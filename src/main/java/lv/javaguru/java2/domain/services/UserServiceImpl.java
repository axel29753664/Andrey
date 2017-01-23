package lv.javaguru.java2.domain.services;


import lv.javaguru.java2.database.EventDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.Event;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.services.dtoConverters.ConverterDto;
import lv.javaguru.java2.servlet.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private BetService betService;
    @Autowired
    private ConverterDto<User, UserDTO> converterDto;

    @Transactional
    public void saveToDB(User user) {
        userDAO.create(user);
    }

    @Transactional
    public void deleteUserById(Long id) {
        betService.deleteBetById(id);
        userDAO.delete(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAll();
    }

    @Override
    public User getById(Long id) {
        return userDAO.getById(id);
    }

    @Override
    public void updateUser(User user) {
        userDAO.update(user);
    }

    @Override
    public User convertUserDTO(UserDTO userDTO) {
        return converterDto.convertFromRequest(userDTO);
    }

    @Override
    public UserDTO convertUser(User user) {
        return converterDto.convertToResponse(user);
    }

    @Override
    public User getUserByLogin(String login) {
        return userDAO.getByLogin(login);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userDAO.getByLogin(userName);
        if (user == null) throw new UsernameNotFoundException("User with login : " + userName + " not found.");
        return user;
    }
}
