package lv.javaguru.java2.domain.services.dtoConverters;

import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.servlet.dto.BetDto;
import lv.javaguru.java2.servlet.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConverterDtoListImpl implements ConverterDtoList{

    @Autowired
    private ConverterBetDto converterBetDto;

    @Autowired
    private ConverterUserDto converterUserDto;

    public List<BetDto> convertBetListToResponse (List<Bet> bets) {
        List<BetDto> betsDto = new ArrayList<>();
        for (Bet bet: bets) {
            BetDto betDto = converterBetDto.convertToResponse(bet);
            betsDto.add(betDto);
        }
        return betsDto;
    }

    public List<UserDto> convertUserListToResponse (List<User> users) {
        List<UserDto> usersDto = new ArrayList<>();
        for (User user: users) {
            UserDto userDto = converterUserDto.convertToResponse(user);
            usersDto.add(userDto);
        }
        return usersDto;
    }

}
