package lv.javaguru.java2.domain.services.factories;

import lv.javaguru.java2.domain.Response;

public interface FactoryBet {

    Response creationProcess(String userIdFromRequest,
                             String eventIdFromRequest,
                             String betSumFromRequest,
                             String betConditionFromRequest);

}
