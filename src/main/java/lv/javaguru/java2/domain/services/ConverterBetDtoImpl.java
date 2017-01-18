package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.BetConditionState;
import lv.javaguru.java2.domain.services.parsers.ParsingFromStringService;
import lv.javaguru.java2.domain.services.parsers.ParsingFromStringToBetConditionStateServiceImpl;
import lv.javaguru.java2.domain.services.parsers.ParsingFromStringToBigDecimalServiceImpl;
import lv.javaguru.java2.domain.services.parsers.ParsingFromStringToLongServiceImpl;
import lv.javaguru.java2.servlet.dto.BetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ConverterBetDtoImpl implements ConverterDto<Bet, BetDto> {

//    @Autowired
//    @Qualifier("StringToLongParser")
//    private ParsingFromStringService parsingFromStringToLongService;
//
//    @Autowired
//    @Qualifier("StringToBigDecimalParser")
//    private ParsingFromStringService parsingFromStringToBigDecimalService;
//
//    @Autowired
//    @Qualifier("StringToBetConditionStateParser")
//    private ParsingFromStringService parsingFromStringToBetConditionStateServiceImpl;


    @Override
    public Bet convertFromRequest(BetDto betDto) {

        Long userId = ParsingFromStringToLongServiceImpl.parse(betDto.getUserId());
        Long eventId = ParsingFromStringToLongServiceImpl.parse(betDto.getEventId());
        BigDecimal betSum = ParsingFromStringToBigDecimalServiceImpl.parse(betDto.getBetSum());
        BetConditionState betCondition = ParsingFromStringToBetConditionStateServiceImpl.parse(betDto.getBetCondition());
        return new Bet(userId, eventId, betSum, betCondition);

    }

    @Override
    public BetDto convertToResponse(Bet bet) {
        String userId = bet.getUserId().toString();
        String eventId = bet.getEventId().toString();
        String betSum = bet.getBetSum().toString();
        String betCondition = bet.getBetCondition().toString();
        return new BetDto(userId, eventId, betSum, betCondition);
    }

}
