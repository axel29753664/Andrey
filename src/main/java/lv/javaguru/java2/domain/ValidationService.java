package lv.javaguru.java2.domain;

import lv.javaguru.java2.database.jdbc.EventDAOImpl;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;

import java.math.BigDecimal;

import static lv.javaguru.java2.domain.BetWinningChoiceState.NOT_APPLIED;

public class ValidationService {

    public ValidationService() {
    }

    public void checkUserId(Long userId) {
        if (userId <= 0) {
            throw new ValidationIllegalStateException("You must be login.");
        }
        UserDAOImpl UserDAO = new UserDAOImpl();
        User userExistence = UserDAO.getById(userId);
        if (userExistence == null) {
            throw new ValidationIllegalStateException("Account doesn't exist.");
        }
    }

    public void checkEventId(Long eventId) {
        if (eventId <= 0) {
            throw new ValidationIllegalStateException("You must choose event before make bet");
        }
        EventDAOImpl EventDAO = new EventDAOImpl();
        Event eventExistence = EventDAO.getById(eventId);
        if (eventExistence == null) {
            throw new ValidationIllegalStateException("Event doesn't exist.");
        }
    }

    public void checkBetSum(BigDecimal betSum) {
        if (betSum.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidationIllegalStateException("Incorrect bet sum.");
        }

        // Проверка достаточно ли средств в кошельке у пользователя

    }

    public void checkWinningChoiceState(BetWinningChoiceState winningChoice) {
        if (winningChoice == NOT_APPLIED) {
            throw new ValidationIllegalStateException("You must choose 'for' or 'against' event.");
        }
    }

}
