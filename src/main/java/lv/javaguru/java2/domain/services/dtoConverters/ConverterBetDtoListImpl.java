package lv.javaguru.java2.domain.services.dtoConverters;

import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.servlet.dto.BetDTO;
import lv.javaguru.java2.servlet.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ConverterBetDtoList")
public class ConverterBetDtoListImpl implements ConverterDtoList<Bet, BetDTO>{

    @Autowired
    private ConverterDTO<Bet, BetDTO> converterBetDto;

    @Override
    public List<BetDTO> convertListToResponse (List<Bet> bets) {
        List<BetDTO> betsDto = new ArrayList<>();
        for (Bet bet: bets) {
            BetDTO betDto = converterBetDto.convertToResponse(bet);
            betsDto.add(betDto);
        }
        return betsDto;
    }

}
