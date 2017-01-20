package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.services.dtoConverters.ConverterBetDto;
import lv.javaguru.java2.domain.services.dtoConverters.ConverterDtoList;
import lv.javaguru.java2.domain.services.dtoConverters.ConverterUserDto;
import lv.javaguru.java2.servlet.dto.BetDto;
import lv.javaguru.java2.servlet.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BetDeletingServiceImpl implements BetDeletingService {

    @Autowired
    private ConverterBetDto converterBetDto;

    @Autowired
    private ConverterUserDto converterUserDto;


    @Autowired
    private ConverterDtoList converterDtoList;

    @Autowired
    private BetService betService;

    @Override
    public List<BetDto> deletingProcess(BetDto betDto, UserDto userForBetDeleting){
        Bet bet = converterBetDto.convertFromRequest(betDto);
        User user = converterUserDto.convertFromRequest(userForBetDeleting);
        betService.deleteBetById(bet.getBetId());
        List<Bet> bets = betService.getBetsByUserId(user.getUserId());
        List<BetDto> betsDto = converterDtoList.convertBetListToResponse(bets);
        return betsDto;
    }

}
