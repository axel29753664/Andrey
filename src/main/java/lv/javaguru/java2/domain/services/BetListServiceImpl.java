package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.services.dtoConverters.ConverterDtoList;
import lv.javaguru.java2.servlet.dto.BetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BetListServiceImpl implements BetListService {

    @Autowired
    @Qualifier("ConverterBetDtoList")
    private ConverterDtoList converterBetDtoList;

    @Autowired
    private BetService betService;

    @Override
    public List<BetDTO> prepareBetList(User user) {
        List<Bet> bets = betService.getBetsByUserId(user.getUserId());
        List<BetDTO> betsDto = converterBetDtoList.convertListToResponse(bets);
        return betsDto;
    }

}
