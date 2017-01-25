package lv.javaguru.java2.domain.services.dtoConverters;

import lv.javaguru.java2.domain.Role;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.servlet.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;


@Service
public class ConverterUserDTO implements ConverterDTO<User, UserDTO> {

    @Override
    public User convertFromRequest(UserDTO userDTO) {
        Long userId = userDTO.getUserId();
        String firstName = userDTO.getFirstName();
        String lastName = userDTO.getLastName();
        String login = userDTO.getLogin();
        String password = userDTO.getPassword();
        BigDecimal balance = userDTO.getBalance();
        Set<Role> roleSet = userDTO.getRoles();
        User user = new User(firstName, lastName, login, password, roleSet, balance);
        user.setUserId(userId);

        return user;
    }

    @Override
    public UserDTO convertToResponse(User user) {
        Long userId = user.getUserId();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String login = user.getLogin();
        String password = user.getPassword();
        Set<Role> roleSet = user.getRoles();
        BigDecimal balance = user.getBalance();

        return new UserDTO(userId, firstName, lastName, login, password, roleSet, balance);
    }
}
