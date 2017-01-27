package lv.javaguru.java2.domain.services.factories;

import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.services.BetService;
import lv.javaguru.java2.domain.services.TransferService;
import lv.javaguru.java2.domain.services.dtoConverters.ConverterDTO;
import lv.javaguru.java2.domain.validators.BetValidator;
import lv.javaguru.java2.servlet.dto.BetDTO;
import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

@Service
public class BetCreationFactory implements CreationFactory<BetDTO> {

    @Autowired
    private BetValidator betValidator;

    @Autowired
    private ConverterDTO<Bet, BetDTO> converterDTO;

    @Autowired
    private BetService betService;

    @Autowired
    private TransferService transferService;


    @Override
    public void create(BetDTO betDTO, Errors validResult) {

        try {
            betValidator.validate(betDTO, validResult);
            betDTO.setUncoveredSum(betDTO.getBetSum());
        } catch (JDBCException e) {
            validResult.rejectValue("betId", "message.validate", "Error validating bet [" + e.getCause().getMessage() + "]");
        }

        if (!validResult.hasErrors()) {
            Bet bet = converterDTO.convertFromRequest(betDTO);
            try {
                applyBetToDB(bet);
            } catch (JDBCException e1) {
                validResult.rejectValue("betId", "message.saveToDBError", "Error save to DB [" + e1.getCause().getMessage() + "]");
            } catch (IllegalArgumentException e2) {
                validResult.rejectValue("betId", "message.saveToDBError", e2.getCause().getMessage());
            }
        }
    }

    @Transactional
    private void applyBetToDB(Bet bet) {
        Bet oppositeBet = betService.getOppositeBet(bet);
        transferService.transferFromUserBalanceToEventBank(bet);
        betService.changeBetsUncoveredSumAndEventBetSide(bet, oppositeBet);
        betService.saveToDB(bet);
    }

}