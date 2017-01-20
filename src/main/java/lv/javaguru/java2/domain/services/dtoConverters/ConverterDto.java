package lv.javaguru.java2.domain.services.dtoConverters;

import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.servlet.dto.BetDto;

public interface ConverterDto<ENTITY, DTO> {

    ENTITY convertFromRequest(DTO dto);

    DTO convertToResponse (ENTITY entity);

}
