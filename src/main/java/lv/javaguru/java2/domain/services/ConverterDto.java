package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.servlet.dto.BetDto;

public interface ConverterDto {

    Bet convertFromRequest(BetDto betDto);

    BetDto convertToResponse (Bet bet);

}
