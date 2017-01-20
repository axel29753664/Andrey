package lv.javaguru.java2.domain.services.dtoConverters;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.services.parsers.ParsingFromStringService;
import lv.javaguru.java2.servlet.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ConverterUserDtoImpl implements ConverterUserDto{

    @Autowired
    @Qualifier("StringToLongParser")
    private ParsingFromStringService parsingFromStringToLongService;

    @Override
    public User convertFromRequest(UserDto userDto){
        Long userId = (Long) parsingFromStringToLongService.parse(userDto.getUserId());
        User user = new User();
        user.setUserId(userId);
        return user;
    }

    @Override
    public UserDto convertToResponse (User user) {
        String userId = user.getUserId().toString();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        return new UserDto(userId, firstName, lastName);
    }

}