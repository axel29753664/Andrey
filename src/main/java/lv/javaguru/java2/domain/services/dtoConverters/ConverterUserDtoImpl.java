package lv.javaguru.java2.domain.services.dtoConverters;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.servlet.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class ConverterUserDtoImpl implements ConverterUserDto{

    @Override
    public User convertFromRequest(UserDto userDto){
        return new User();
    }

    @Override
    public UserDto convertToResponse (User user) {
        String userId = user.getUserId().toString();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        return new UserDto(userId, firstName, lastName);
    }

}