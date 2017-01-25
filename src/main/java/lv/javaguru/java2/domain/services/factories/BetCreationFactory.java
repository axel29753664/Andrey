package lv.javaguru.java2.domain.services.factories;

import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.services.BetService;
import lv.javaguru.java2.domain.services.dtoConverters.ConverterDTO;
import lv.javaguru.java2.domain.validators.BetValidator;
import lv.javaguru.java2.servlet.dto.BetDTO;
import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@Service
public class BetCreationFactory implements CreationFactory<BetDTO> {

    @Autowired
    private BetValidator betValidator;

    @Autowired
    private ConverterDTO<Bet, BetDTO> converterDTO;

    @Autowired
    private BetService betService;


    public void create(BetDTO betDTO, Errors validResult) {

        try {
            betValidator.validate(betDTO, validResult);
        } catch (JDBCException e) {
            validResult.rejectValue("betId", "message.validate", "Error validating bet [" + e.getCause().getMessage() + "]");
        }

        if (!validResult.hasErrors()) {
            Bet bet = converterDTO.convertFromRequest(betDTO);
            try {
                betService.saveToDB(bet);
            } catch (JDBCException e) {
                validResult.rejectValue("betId", "message.saveToDBError", "Error save to DB [" + e.getCause().getMessage() + "]");
            }
        }
    }

}