package lv.javaguru.java2.domain.services.factories;

import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.services.dtoConverters.ConverterDTO;
import lv.javaguru.java2.domain.validators.BetValidator;
import lv.javaguru.java2.servlet.dto.BetDTO;
import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@Service
public class BetCreationEntityFactory implements CreationEntityFactory<BetDTO, Bet>{

    @Autowired
    private BetValidator betValidator;

    @Autowired
    private ConverterDTO<Bet, BetDTO> converterDTO;

    @Override
    public Bet create(BetDTO betDTO, Errors validResult) {
        try {
            betValidator.validate(betDTO, validResult);
            betDTO.setUncoveredSum(betDTO.getBetSum());
        } catch (JDBCException e) {
            validResult.rejectValue("betId", "message.validate", "Error validating bet [" + e.getCause().getMessage() + "]");
        }

        Bet bet = null;
        if (!validResult.hasErrors()) {
            bet = converterDTO.convertFromRequest(betDTO);
        }
        return bet;
    }

}
