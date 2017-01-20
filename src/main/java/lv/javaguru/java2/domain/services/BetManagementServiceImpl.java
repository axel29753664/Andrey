package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.services.dtoConverters.ConverterDto;
import lv.javaguru.java2.domain.services.dtoConverters.ConverterDtoList;
import lv.javaguru.java2.servlet.dto.BetDto;
import lv.javaguru.java2.servlet.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BetManagementServiceImpl implements BetManagementService{

    @Autowired
    private ConverterDto<User, UserDTO> converterUserDto;

    @Autowired
    private ConverterDtoList converterDtoList;

    @Autowired
    private BetService betService;

    @Autowired
    private UserService userService;


    @Override
    public List<UserDTO> prepareUserList() {
        List<User> users = userService.getAllUsers();
        List<UserDTO> usersDto = converterDtoList.convertUserListToResponse(users);
        return usersDto;
    }

    @Override
    public List<BetDto> managementProcess(UserDTO userDTO){
        User user = converterUserDto.convertFromRequest(userDTO);
        List<Bet> bets = betService.getBetsByUserId(user.getUserId());
        List<BetDto> betsDto = converterDtoList.convertBetListToResponse(bets);
        return betsDto;
    }

}
