package lv.javaguru.java2.domain.services.factories;

import lv.javaguru.java2.database.BetDAO;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.Response;
import lv.javaguru.java2.domain.services.dtoConverters.ConverterDto;
import lv.javaguru.java2.domain.validators.betValidation.BetValidator;
import lv.javaguru.java2.domain.validators.betValidation.BetValidationError;
import lv.javaguru.java2.servlet.dto.BetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

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
    private ConverterDto<Bet,BetDto> converterDto;
    private BetService betService;

    private List<BetValidationError> errors = new ArrayList();
    private Response response = new Response();


    public Response creationProcess(BetDto betDtoFromRequest){

        Bet bet = converterDto.convertFromRequest(betDtoFromRequest);
        errors = betValidator.validate(bet);

        if (errors.size() == 0) {
            try {
                betService.writeInDatabase(bet);
                BetDto betDto = converterDto.convertToResponse(bet);
                buildResponseWithBet(betDto);
            } catch (DBException e) {
                buildResponseWithDbError(e);
            }
        } else {
            buildResponseWithErrors(errors);
        }
        return response;
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
