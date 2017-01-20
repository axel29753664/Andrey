package lv.javaguru.java2.domain.services.dtoConverters;

import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.servlet.dto.BetDto;
import lv.javaguru.java2.servlet.dto.UserDTO;

import java.util.List;

public interface ConverterDtoList {

    List<BetDto> convertBetListToResponse (List<Bet> bets);

    List<UserDTO> convertUserListToResponse (List<User> users);

}