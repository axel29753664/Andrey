package lv.javaguru.java2.domain.services.dtoConverters;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.servlet.dto.UserDto;

public interface ConverterUserDto {

    User convertFromRequest(UserDto userDto);

    UserDto convertToResponse (User user);

}
