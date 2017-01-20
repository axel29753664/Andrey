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
public class BetDeletingServiceImpl implements BetDeletingService {

    @Autowired
    private ConverterDto<Bet, BetDto> converterBetDto;

    @Autowired
    private ConverterDto<User,UserDTO> converterUserDto;


    @Autowired
    private ConverterDtoList converterDtoList;

    @Autowired
    private BetService betService;

    @Override
    public List<BetDto> deletingProcess(BetDto betDto, UserDTO userForBetDeleting){
        Bet bet = converterBetDto.convertFromRequest(betDto);
        User user = converterUserDto.convertFromRequest(userForBetDeleting);
        betService.deleteBetById(bet.getBetId());
        List<Bet> bets = betService.getBetsByUserId(user.getUserId());
        List<BetDto> betsDto = converterDtoList.convertBetListToResponse(bets);
        return betsDto;
    }

}
