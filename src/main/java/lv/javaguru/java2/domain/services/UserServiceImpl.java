package lv.javaguru.java2.domain.services;


import lv.javaguru.java2.database.EventDAO;
import lv.javaguru.java2.database.RoleDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.Event;
import lv.javaguru.java2.domain.Role;
import lv.javaguru.java2.domain.Roles;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private UserDAO userDAO;

    @Transactional
    public void saveToDB(User user) {
        if (user.getRoles().size() == 0) {
            setDefaultUserRoles(user);
        }
        userDAO.create(user);
    }

    private void setDefaultUserRoles(User user) {
        Set<Role> roles = new HashSet<>();
        Role role = new Role();                                   //set default access ROLE_USER
        role.setId(Roles.ROLE_USER.getIdInDB());
        role.setRole(Roles.ROLE_USER);
        roles.add(role);
        user.setRoles(roles);
    }

    @Override
    public void createEvent(Event event) {
        eventDAO.create(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventDAO.getAll();
    }

    @Override
    public Event getEventById(Long eventId) {
        return eventDAO.getById(eventId);
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
