package lv.javaguru.java2.domain.services.dtoConverters;

import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.servlet.dto.BetDto;

public interface ConverterBetDto {

    Bet convertFromRequest(BetDto betDto);

    BetDto convertToResponse (Bet user);

}