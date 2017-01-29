package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.services.dtoConverters.ConverterDtoList;
import lv.javaguru.java2.domain.services.parsers.ParserStringToLong;
import lv.javaguru.java2.servlet.dto.BetDTO;
import lv.javaguru.java2.servlet.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BetManagementServiceImpl implements BetManagementService{

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
        List<UserDTO> usersDTO = converterUserDtoList.convertListToResponse(users);
        return usersDTO;
    }

    @Override
    public List<BetDTO> managementProcess(String userIdFromRequest){
        Long userId = ParserStringToLong.parse(userIdFromRequest);
        List<Bet> bets = betService.getBetsByUserId(userId);
        List<BetDTO> betsDto = converterBetDtoList.convertListToResponse(bets);
        return betsDto;
    }

}