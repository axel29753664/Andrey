package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.services.dtoConverters.ConverterDTO;
import lv.javaguru.java2.domain.services.dtoConverters.ConverterDtoList;
import lv.javaguru.java2.servlet.dto.BetDTO;
import lv.javaguru.java2.servlet.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BetManagementServiceImpl implements BetManagementService{

    @Autowired
    private ConverterDTO<User, UserDTO> converterUserDto;

    @Autowired
    @Qualifier("ConverterBetDtoList")
    private ConverterDtoList converterBetDtoList;

    @Autowired
    @Qualifier("ConverterUserDtoList")
    private ConverterDtoList converterUserDtoList;

    @Autowired
    private BetService betService;

    @Autowired
    private UserService userService;


    @Override
    public List<UserDTO> prepareUserList() {
        List<User> users = userService.getAllUsers();
        List<UserDTO> usersDto = converterUserDtoList.convertListToResponse(users);
        return usersDto;
    }

    @Override
    public List<BetDTO> managementProcess(UserDTO userDTO){
        User user = converterUserDto.convertFromRequest(userDTO);
        List<Bet> bets = betService.getBetsByUserId(user.getUserId());
        List<BetDTO> betsDto = converterBetDtoList.convertListToResponse(bets);
        return betsDto;
    }

}