package lv.javaguru.java2.domain;

import java.math.BigDecimal;

import static lv.javaguru.java2.domain.BetWinningChoiceState.NOT_APPLIED;

public class ValidationServiceBetCreation {

    public ValidationServiceBetCreation() {
    }

    public void check(Long userId,
                      Long eventId,
                      BigDecimal betSum,
                      BetWinningChoiceState winningChoice) {

        ValidateUserId validateUserId = new ValidateUserId();
        validateUserId.check(userId);
        ValidateEventId validateEventId = new ValidateEventId();
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
