package lv.javaguru.java2.domain.betValidation;

import lv.javaguru.java2.database.EventDAO;
import lv.javaguru.java2.database.jdbc.EventDAOImpl;
import lv.javaguru.java2.domain.Bet;

import java.util.List;

public class WinningStateBetRule implements BetRule {
    EventDAO eventDao = new EventDAOImpl();

    public void apply(Bet bet, List<BetValidationError> errorList) {
        if (bet.getWinningCondition().equals(null)){
            errorList.add(BetValidationError.WINNING_CONDITION_NOT_CHOSEN);
        }
    }

}
