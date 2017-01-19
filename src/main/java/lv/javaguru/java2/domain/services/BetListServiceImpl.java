package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.services.dtoConverters.ConverterDtoList;
import lv.javaguru.java2.servlet.dto.BetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BetListServiceImpl implements BetListService {

    @Autowired
    private ConverterDtoList converterDtoList;

    @Autowired
    private BetService betService;

    @Override
    public List<BetDto> prepareBetList(User user) {
        List<Bet> bets = betService.getBetsByUserId(user.getUserId());
        List<BetDto> betsDto = converterDtoList.convertBetListToResponse(bets);
        return betsDto;
    }

}
