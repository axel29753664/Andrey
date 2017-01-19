package lv.javaguru.java2.domain.services.dtoConverters;

import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.BetConditionState;
import lv.javaguru.java2.domain.services.parsers.ParsingFromStringService;
import lv.javaguru.java2.servlet.dto.BetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ConverterBetDtoImpl implements ConverterBetDto {

    @Autowired
    @Qualifier("StringToLongParser")
    private ParsingFromStringService parsingFromStringToLongService;

    @Autowired
    @Qualifier("StringToBigDecimalParser")
    private ParsingFromStringService parsingFromStringToBigDecimalService;

    @Autowired
    @Qualifier("StringToBetConditionStateParser")
    private ParsingFromStringService parsingFromStringToBetConditionStateServiceImpl;


    @Override
    public Bet convertFromRequest(BetDto betDto){
        Long betId = (Long) parsingFromStringToLongService.parse(betDto.getBetId());
        Long userId = (Long) parsingFromStringToLongService.parse(betDto.getUserId());
        Long eventId = (Long) parsingFromStringToLongService.parse(betDto.getEventId());
        BigDecimal betSum = (BigDecimal) parsingFromStringToBigDecimalService.parse(betDto.getBetSum());
        BetConditionState betCondition = (BetConditionState) parsingFromStringToBetConditionStateServiceImpl.parse(betDto.getBetCondition());
        return new Bet(betId, userId, eventId, betSum, betCondition);
    }

   @Override
    public BetDto convertToResponse (Bet bet) {
        String betId = bet.getBetId().toString();
        String userId = bet.getUserId().toString();
        String eventId = bet.getEventId().toString();
        String betSum = bet.getBetSum().toString();
        String betCondition = bet.getBetCondition().toString();
        return new BetDto(betId, userId, eventId, betSum, betCondition);
    }

}