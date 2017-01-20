package lv.javaguru.java2.domain.services.dtoConverters;


import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.servlet.dto.UserDTO;
import org.springframework.stereotype.Service;


@Service
public class ConverterUserDTO implements ConverterDto<User, UserDTO> {

    @Override
    public User convertFromRequest(UserDTO userDTO) {

        String firstName = userDTO.getFirstName();
        String lastName = userDTO.getLastName();
        String login = userDTO.getLogin();
        String password = userDTO.getPassword();

        return new User(firstName, lastName, login, password);
    }

    @Override
    public UserDTO convertToResponse(User user) {
        return null;
    }
}
