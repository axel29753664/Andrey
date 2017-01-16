package lv.javaguru.java2.domain.services.factories;

import lv.javaguru.java2.domain.Response;
import lv.javaguru.java2.servlet.dto.BetDto;

public interface FactoryBet {

    Response creationProcess(BetDto betDto);

}
