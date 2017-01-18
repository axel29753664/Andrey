package lv.javaguru.java2.domain.services;


import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.services.parsers.ParsingFromStringService;
import lv.javaguru.java2.domain.services.parsers.ParsingFromStringToLongServiceImpl;
import lv.javaguru.java2.servlet.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ConverterUserDTO implements ConverterDto<User, UserDTO> {

    @Override
    public User convertFromRequest(UserDTO userDTO) {

        ParsingFromStringToLongServiceImpl.parse(userDTO.getUserId());
        return null;
    }

    @Override
    public UserDTO convertToResponse(User bet) {
        return null;
    }
}
