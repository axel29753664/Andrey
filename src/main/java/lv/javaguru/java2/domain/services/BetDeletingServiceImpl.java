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
public class BetDeletingServiceImpl implements BetDeletingService {

    @Autowired
    private ConverterDTO<Bet, BetDTO> converterBetDto;

    @Autowired
    private ConverterDTO<User,UserDTO> converterUserDto;

    @Autowired
    @Qualifier("ConverterBetDtoList")
    private ConverterDtoList converterBetDtoList;

    @Autowired
    private BetService betService;

    @Override
    public List<BetDTO> deletingProcess(BetDTO betDto, UserDTO userForBetDeleting){    // nuzhno tolko UserId, zachem ves user ?
        Bet bet = converterBetDto.convertFromRequest(betDto);
        User user = converterUserDto.convertFromRequest(userForBetDeleting); // userDTO.getId.parseLong
        betService.deleteBetById(bet.getBetId());
        List<Bet> bets = betService.getBetsByUserId(user.getUserId());
        List<BetDTO> betsDto = converterBetDtoList.convertListToResponse(bets);
        return betsDto;
    }

}
