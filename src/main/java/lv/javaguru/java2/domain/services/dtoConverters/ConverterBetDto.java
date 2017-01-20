package lv.javaguru.java2.domain.services.dtoConverters;

import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.BetConditionState;
import lv.javaguru.java2.domain.services.parsers.ParserStringToBetConditionState;
import lv.javaguru.java2.domain.services.parsers.ParserStringToBigDecimal;
import lv.javaguru.java2.domain.services.parsers.ParserStringToLong;
import lv.javaguru.java2.servlet.dto.BetDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ConverterBetDto implements ConverterDto<Bet, BetDto> {

    @Override
    public Bet convertFromRequest(BetDto betDto) {
        Long betId = ParserStringToLong.parse(betDto.getBetId());
        Long userId = ParserStringToLong.parse(betDto.getUserId());
        Long eventId = ParserStringToLong.parse(betDto.getEventId());
        BigDecimal betSum = ParserStringToBigDecimal.parse(betDto.getBetSum());
        BetConditionState betCondition = ParserStringToBetConditionState.parse(betDto.getBetCondition());
        return new Bet(betId, userId, eventId, betSum, betCondition);

    }

    @Override
    public BetDto convertToResponse(Bet bet) {
        String betId = bet.getBetId().toString();
        String userId = bet.getUserId().toString();
        String eventId = bet.getEventId().toString();
        String betSum = bet.getBetSum().toString();
        String betCondition = bet.getBetCondition().toString();
        return new BetDto(betId, userId, eventId, betSum, betCondition);

    }

}
