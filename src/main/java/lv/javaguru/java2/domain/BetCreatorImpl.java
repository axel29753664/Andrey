package lv.javaguru.java2.domain;

import lv.javaguru.java2.database.jdbc.BetDAOImpl;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;

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

        checkUserId(userId);
        checkEventId(eventId);
        checkBetSum(betSum);
        checkWinningChoiceState(winningChoice);
        Boolean winningChoiceBoolean = convertWinningChoiceToBoolean(winningChoice);
        Bet bet = new Bet (userId, eventId, betSum, winningChoiceBoolean);
        BetDAOImpl betDAO = new BetDAOImpl();
        betDAO.create(bet);

    }

    private void checkUserId(Long userId) {
        if (userId <= 0) {
            throw new BetIllegalStateException("You must be login");
        }
        UserDAOImpl UserDAO = new UserDAOImpl();
        User userExistence = UserDAO.getById(userId);
        if (userExistence == null) {
            throw new BetIllegalStateException("Invalid account");
        }
    }

    private void checkEventId(Long eventId) {
        if (eventId <= 0) {
            throw new BetIllegalStateException("You must choose event before make bet");
        }
        /* Проверка существования Ивента в БД */
    }

    private void checkBetSum(BigDecimal betSum) {
        if (betSum.compareTo(BigDecimal.ZERO) <= 0) {
            throw new BetIllegalStateException("Incorrect bet sum");
        }
        /* Проверка достаточно ли средств в кошельке у пользователя */
    }

    private void checkWinningChoiceState(BetWinningChoiceState winningChoice) {
        if (winningChoice == NOT_APPLIED) {
            throw new BetIllegalStateException("You must choose, You bet 'for' or 'against' event");
        }
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

}
