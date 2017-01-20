package lv.javaguru.java2.domain.services.dtoConverters;

import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.servlet.dto.BetDto;
import lv.javaguru.java2.servlet.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConverterDtoListImpl implements ConverterDtoList{

    @Autowired
    private ConverterBetDto converterBetDto;

    @Autowired
    private ConverterDto<User,UserDTO> converterUserDto;

    public List<BetDto> convertBetListToResponse (List<Bet> bets) {
        List<BetDto> betsDto = new ArrayList<>();
        for (Bet bet: bets) {
            BetDto betDto = converterBetDto.convertToResponse(bet);
            betsDto.add(betDto);
        }
        return betsDto;
    }

    public List<UserDTO> convertUserListToResponse (List<User> users) {
        List<UserDTO> usersDto = new ArrayList<>();
        for (User user: users) {
            UserDTO userDTO = converterUserDto.convertToResponse(user);
            usersDto.add(userDTO);
        }
        return usersDto;
    }

}
