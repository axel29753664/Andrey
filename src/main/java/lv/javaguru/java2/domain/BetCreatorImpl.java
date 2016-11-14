package lv.javaguru.java2.domain;

import lv.javaguru.java2.database.jdbc.BetDAOImpl;

import java.math.BigDecimal;

import static lv.javaguru.java2.domain.BetWinningChoiceState.FOR;
import static lv.javaguru.java2.domain.BetWinningChoiceState.NOT_APPLIED;

public class BetCreatorImpl implements BetCreator {

    public BetCreatorImpl() {
    }

    public void createBet(Long userId,
                          Long eventId,
                          BigDecimal betSum,
                          BetWinningChoiceState winningChoice) {

        validate(userId, eventId, betSum, winningChoice);
        Bet bet = create(userId, eventId, betSum, winningChoice);
        writeInDao(bet);

        System.out.println(bet);
    }

    private void validate(Long userId,
                          Long eventId,
                          BigDecimal betSum,
                          BetWinningChoiceState winningChoice) {

        ValidationService validationService = new ValidationService();
        validationService.checkUserId(userId);
        validationService.checkEventId(eventId);
        validationService.checkBetSum(betSum);
        validationService.checkWinningChoiceState(winningChoice);
    }

    private Bet create(Long userId,
                       Long eventId,
                       BigDecimal betSum,
                       BetWinningChoiceState winningChoice) {

        Boolean winningChoiceBoolean = convertWinningChoiceToBoolean(winningChoice);
        Bet bet = new Bet (userId, eventId, betSum, winningChoiceBoolean);
        return bet;
    }

    private Boolean convertWinningChoiceToBoolean(BetWinningChoiceState winningChoice) {
        Boolean winningChoiceBoolean;
        if (winningChoice == FOR) {
            winningChoiceBoolean = true;
        } else {
            winningChoiceBoolean = false;
        }
        return winningChoiceBoolean;
    }

    private void writeInDao(Bet bet) {
        BetDAOImpl betDAO = new BetDAOImpl();
        betDAO.create(bet);
    }

}
