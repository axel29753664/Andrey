package lv.javaguru.java2.domain.services.dtoConverters;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.servlet.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ConverterUserDtoList")
public class ConverterUserDtoListImpl implements ConverterDtoList<User, UserDTO>{

    @Autowired
    private ConverterDTO<User, UserDTO> converterBetDto;

    @Override
    public List<UserDTO> convertListToResponse (List<User> users) {
        List<UserDTO> betsDto = new ArrayList<>();
        for (User user: users) {
            UserDTO betDto = converterBetDto.convertToResponse(user);
            betsDto.add(betDto);
        }
        return betsDto;
    }

}
