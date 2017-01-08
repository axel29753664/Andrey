package lv.javaguru.java2.servlet.controllers;

import lv.javaguru.java2.domain.BetCreator;
import lv.javaguru.java2.domain.BetCreatorImpl;
import lv.javaguru.java2.domain.BetWinningConditionState;
import lv.javaguru.java2.domain.Response;
import lv.javaguru.java2.servlet.MVCController;
import lv.javaguru.java2.servlet.MVCModel;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

import static lv.javaguru.java2.domain.BetWinningConditionState.AGAINST;
import static lv.javaguru.java2.domain.BetWinningConditionState.FOR;
import static lv.javaguru.java2.domain.BetWinningConditionState.NOT_APPLIED;

@Component
public class MakeBetController implements MVCController {

    @Override
    public MVCModel processGet(HttpServletRequest req) {
        return new MVCModel("/error.jsp", "Incorrect request");
    }

    @Override
    public MVCModel processPost(HttpServletRequest req) {

        String userIdFromRequest = req.getParameter("userID");
        String eventIdFromRequest = req.getParameter("eventID");
        String betSumFromRequest = req.getParameter("betSum");
        String winningConditionFromRequest = req.getParameter("winningCondition");

        BetWinningConditionState winningCondition = NOT_APPLIED;

        Long userId = Long.parseLong(userIdFromRequest);
        Long eventId = Long.parseLong(eventIdFromRequest);
        BigDecimal betSum = BigDecimal.valueOf(Long.parseLong(betSumFromRequest));

        if (winningConditionFromRequest.equalsIgnoreCase("FOR")) {
            winningCondition = FOR;
        }
        if (winningConditionFromRequest.equalsIgnoreCase("AGAINST")) {
            winningCondition = AGAINST;
        }

        BetCreator BetCreator = new BetCreatorImpl();
        Response response = BetCreator.createBet(userId, eventId, betSum, winningCondition);

        if (response.getDbError() != null) {
            return new MVCModel("/dbErrorMessage.jsp", response.getDbError());
        }
        if (response.getErrorsList() != null) {
            return new MVCModel("/makeBetError.jsp", response.getErrorsList());
        }
        String data = "Bet is registered with id " + response.getBet().getBetId();
        return new MVCModel("/makeBetConfirmation.jsp", data);

    }

}


