package lv.javaguru.java2.domain.services.factories;

import lv.javaguru.java2.database.BetDAO;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.BetConditionState;
import lv.javaguru.java2.domain.Response;
import lv.javaguru.java2.domain.services.ConverterDto;
import lv.javaguru.java2.domain.services.parsers.ParsingFromStringService;
import lv.javaguru.java2.domain.validators.betValidation.BetValidator;
import lv.javaguru.java2.domain.validators.betValidation.BetValidationError;
import lv.javaguru.java2.servlet.dto.BetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Scope("prototype")
public class FactoryBetImpl implements FactoryBet {

    @Autowired
    private BetValidator betValidator;

    @Autowired
    private BetDAO betDAO;

    @Autowired
    private ConverterDto converterDto;

    private List<BetValidationError> errors = new ArrayList();
    private Response response = new Response();


    public Response creationProcess(BetDto betDtoFromRequest){

        Bet bet = converterDto.convertFromRequest(betDtoFromRequest);
        errors = betValidator.validate(bet);

        if (errors.size() == 0) {
            try {
                writeInDao(bet);
                BetDto betDtoToResponse = converterDto.convertToResponse(bet);
                buildResponseWithBet(betDtoToResponse);
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

    private void buildResponseWithBet(BetDto betDto) {
        response.setBetDto(betDto);
    }

    private void buildResponseWithDbError(DBException e) {
        response.setDbError(e.getMessage());
    }

    private void buildResponseWithErrors (List<BetValidationError> errors) {
        response.setErrorsList(errors);
    }


}
