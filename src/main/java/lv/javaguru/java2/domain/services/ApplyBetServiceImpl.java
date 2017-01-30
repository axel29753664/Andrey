package lv.javaguru.java2.domain.services;

import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.services.dtoConverters.ConverterDTO;
import lv.javaguru.java2.domain.services.factories.BetCreationEntityFactory;
import lv.javaguru.java2.servlet.dto.BetDTO;
import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

@Service
public class ApplyBetServiceImpl implements ApplyBetService {


    @Autowired
    private ConverterDTO<Bet, BetDTO> converterDTO;

    @Autowired
    private BetService betService;

    @Autowired
    private EventServices eventService;

    @Autowired
    private TransferService transferService;

    @Autowired
    private BetCreationEntityFactory betCreationFactory;

    @Transactional
    public void apply(BetDTO betDTO, Errors validResult) {

        Bet bet = betCreationFactory.create(betDTO, validResult);
        if (!validResult.hasErrors()) {
            Bet oppositeBet = betService.getOppositeBet(bet);
            betCreationProcess(bet, oppositeBet, validResult);
        }
    }


    private void betCreationProcess(Bet bet, Bet oppositeBet, Errors validResult) {
        if (oppositeBet != null) {
            Double coefficient = eventService.getCoefficientDependingOnBetState(bet.getBetCondition(), bet.getEventId());
            betService.changeBetsUncoveredSumAndEventBetSide(bet, oppositeBet, coefficient);
        } else {
            betService.changeEventBetSide(bet);
        }
        try {
            betService.saveToDB(bet);
            transferService.transferFromUserBalanceToEventBank(bet);
        } catch (JDBCException e1) {
            validResult.rejectValue("betId", "message.saveToDBError", "Error save to DB [" + e1.getCause().getMessage() + "]");
        } catch (IllegalArgumentException e2) {
            validResult.rejectValue("betId", "message.saveToDBError", e2.getCause().getMessage());
        }
    }

}
