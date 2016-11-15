package lv.javaguru.java2.domain;

import java.math.BigDecimal;

import static lv.javaguru.java2.domain.BetWinningChoiceState.NOT_APPLIED;

public class ValidationServiceBetCreation {
    ValidateUserId validateUserId;
    ValidateEventId validateEventId;


    public ValidationServiceBetCreation() {
        validateUserId = new ValidateUserId();
        validateEventId = new ValidateEventId();
    }

    public void check(long userId,
                      long eventId,
                      BigDecimal betSum,
                      BetWinningChoiceState winningChoice) {

        validateUserId.check(userId);
        validateEventId.check(eventId);
        checkBetSum(betSum);
        checkWinningChoiceState(winningChoice);
    }

    private void checkBetSum(BigDecimal betSum) {
        if (betSum.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidationIllegalStateException("Incorrect bet sum.");
        }
        // Проверка достаточно ли средств в кошельке у пользователя
    }

    private void checkWinningChoiceState(BetWinningChoiceState winningChoice) {
        if (winningChoice == NOT_APPLIED) {
            throw new ValidationIllegalStateException("You must choose 'for' or 'against' event.");
        }
    }

}
