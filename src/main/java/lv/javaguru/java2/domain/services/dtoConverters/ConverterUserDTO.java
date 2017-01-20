package lv.javaguru.java2.domain.services.dtoConverters;


import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.services.parsers.ParserStringToLong;
import lv.javaguru.java2.servlet.dto.UserDTO;
import org.springframework.stereotype.Service;


@Service
public class ConverterUserDTO implements ConverterDto<User, UserDTO> {

    @Override
    public User convertFromRequest(UserDTO userDTO) {
        Long userId = ParserStringToLong.parse(userDTO.getUserId());
        String firstName = userDTO.getFirstName();
        String lastName = userDTO.getLastName();
        String login = userDTO.getLogin();
        String password = userDTO.getPassword();
        User user =new User(firstName, lastName, login, password);
        user.setUserId(userId);

        return user;
    }

    @Override
    public UserDTO convertToResponse(User user) {

        String userId = user.getUserId().toString();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String login = user.getLogin();
        String password = user.getPassword();
        return new UserDTO(userId, firstName, lastName, login, password);

    }
}
