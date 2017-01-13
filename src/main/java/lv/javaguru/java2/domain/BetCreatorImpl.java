package lv.javaguru.java2.domain;

import lv.javaguru.java2.database.BetDAO;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.betValidation.BetPolicy;
import lv.javaguru.java2.domain.betValidation.BetValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class BetCreatorImpl implements BetCreator {

    private List<BetValidationError> errors = new ArrayList();
    private Response response = new Response();

    @Autowired
    private BetPolicy betPolicy;

    @Autowired
    private BetDAO betDAO;

    public BetCreatorImpl() {
    }

    public Response createBet(Long userId,
                              Long eventId,
                              BigDecimal betSum,
                              BetWinningConditionState betCondition) {

        Bet bet = create(userId, eventId, betSum, betCondition);
        errors = betPolicy.validate(bet);

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

    private Bet create(Long userId,
                       Long eventId,
                       BigDecimal betSum,
                       BetWinningConditionState betCondition) {

        Bet bet = new Bet (userId, eventId, betSum, betCondition);
        return bet;
    }

    public void writeInDao(Bet bet) {
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