package lv.javaguru.java2.domain.services.factories;

import lv.javaguru.java2.database.BetDAO;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.BetConditionState;
import lv.javaguru.java2.domain.Response;
import lv.javaguru.java2.domain.services.parsers.ParsingFromStringService;
import lv.javaguru.java2.domain.validators.betValidation.BetValidator;
import lv.javaguru.java2.domain.validators.betValidation.BetValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
//@Scope("prototype")
public class FactoryBetImpl implements FactoryBet {

    @Autowired
    private BetValidator betValidator;

    @Autowired
    private BetDAO betDAO;

    @Autowired
    @Qualifier("StringToLongParser")
    private ParsingFromStringService parsingFromStringToLongService;

    @Autowired
    @Qualifier("StringToBigDecimalParser")
    private ParsingFromStringService parsingFromStringToBigDecimalService;

    @Autowired
    @Qualifier("StringToBetConditionStateParser")
    private ParsingFromStringService parsingFromStringToBetConditionStateServiceImpl;

    private List<BetValidationError> errors = new ArrayList();
    private Response response = new Response();


    public Response creationProcess(String userIdFromRequest,
                                    String eventIdFromRequest,
                                    String betSumFromRequest,
                                    String betConditionFromRequest){

        Long userId = (Long) parsingFromStringToLongService.parse(userIdFromRequest);
        Long eventId = (Long) parsingFromStringToLongService.parse(eventIdFromRequest);
        BigDecimal betSum = (BigDecimal) parsingFromStringToBigDecimalService.parse(betSumFromRequest);
        BetConditionState betCondition = (BetConditionState) parsingFromStringToBetConditionStateServiceImpl.parse(betConditionFromRequest);

        Bet bet = new Bet (userId, eventId, betSum, betCondition);
        errors = betValidator.validate(bet);

        if (errors.size() == 0) {
            try {
                writeInDao(bet);
                buildResponseWithBet(bet);
            } catch (DBException e) {
                buildResponseWithDbError(e);
            }
        } else {
            buildResponseWithErrors(errors);
        }
        return response;
    }


    private void writeInDao(Bet bet) {
        betDAO.create(bet);
    }

    private void buildResponseWithBet(Bet bet) {
        response.setBet(bet);
    }

    private void buildResponseWithDbError(DBException e) {
        response.setDbError(e.getMessage());
    }

    private void buildResponseWithErrors (List<BetValidationError> errors) {
        response.setErrorsList(errors);
    }


}
