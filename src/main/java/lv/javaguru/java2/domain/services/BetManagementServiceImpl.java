package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.services.dtoConverters.ConverterDtoList;
import lv.javaguru.java2.servlet.dto.BetDto;
import lv.javaguru.java2.servlet.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BetManagementServiceImpl implements BetManagementService{

    @Autowired
    private ConverterUserDto converterUserDto;

    @Autowired
    private ConverterDtoList converterDtoList;

    @Autowired
    private BetService betService;

    @Autowired
    private AdminService adminService;


    @Override
    public List<UserDto> prepareUserList() {
        List<User> users = adminService.getAllUsers();
        List<UserDto> usersDto = converterDtoList.convertUserListToResponse(users);
        return usersDto;
    }

    @Override
    public List<BetDto> managementProcess(UserDto userDto){
        User user = converterUserDto.convertFromRequest(userDto);
        List<Bet> bets = betService.getBetsByUserId(user.getUserId());
        List<BetDto> betsDto = converterDtoList.convertBetListToResponse(bets);
        return betsDto;
    }

}
