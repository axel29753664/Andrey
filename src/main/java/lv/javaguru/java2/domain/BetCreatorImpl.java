package lv.javaguru.java2.domain;

import lv.javaguru.java2.config.SpringAppConfig;
import lv.javaguru.java2.database.BetDAO;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.betValidation.BetPolicy;
import lv.javaguru.java2.domain.betValidation.BetValidationError;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static lv.javaguru.java2.domain.BetWinningConditionState.AGAINST;
import static lv.javaguru.java2.domain.BetWinningConditionState.FOR;

public class BetCreatorImpl implements BetCreator {

    private List<BetValidationError> errors = new ArrayList();
    private Response response = new Response();
    private BetPolicy betPolicy;
    private BetDAO betDAO;

    public BetCreatorImpl() {
    }

    public Response createBet(Long userId,
                              Long eventId,
                              BigDecimal betSum,
                              BetWinningConditionState winningCondition) {

        ApplicationContext springContext = new AnnotationConfigApplicationContext(SpringAppConfig.class);
        betDAO = springContext.getBean(BetDAO.class);
        betPolicy = springContext.getBean(BetPolicy.class);

        Bet bet = create(userId, eventId, betSum, winningCondition);
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
                       BetWinningConditionState winningCondition) {

        Boolean winningConditionBoolean = convertWinningConditionToBoolean(winningCondition);
        Bet bet = new Bet (userId, eventId, betSum, winningConditionBoolean);
        return bet;
    }

    private Boolean convertWinningConditionToBoolean(BetWinningConditionState winningCondition) {
        Boolean winningConditionBoolean = null;
        if (winningCondition == FOR) {
            winningConditionBoolean = true;
        }
        if (winningCondition == AGAINST) {
            winningConditionBoolean = false;
        }
        return winningConditionBoolean;
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