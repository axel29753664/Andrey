package lv.javaguru.java2.domain.services.dtoConverters;

import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.BetConditionState;
import lv.javaguru.java2.servlet.dto.BetDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ConverterBetDTO implements ConverterDTO<Bet, BetDTO> {

    @Override
    public Bet convertFromRequest(BetDTO betDTO) {
        Long betId = betDTO.getBetId();
        Long userId = betDTO.getUserId();
        Long eventId = betDTO.getEventId();
        BigDecimal betSum = betDTO.getBetSum();
        BigDecimal uncoveredSum = betDTO.getUncoveredSum();
        BetConditionState betCondition = betDTO.getBetCondition();

        return new Bet(betId, userId, eventId, betSum, uncoveredSum, betCondition);
    }

    @Override
    public BetDTO convertToResponse(Bet bet) {
        Long betId = bet.getBetId();
        Long userId = bet.getUserId();
        Long eventId = bet.getEventId();
        BigDecimal betSum = bet.getBetSum();
        BigDecimal uncoveredSum = bet.getUncoveredSum();
        BetConditionState betCondition = bet.getBetCondition();

        return new BetDTO(betId, userId, eventId, betSum, uncoveredSum, betCondition);
    }

}
