package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.BetCreatorImpl;
import lv.javaguru.java2.domain.BetWinningConditionState;
import lv.javaguru.java2.domain.Response;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        Long userId = new Long(userIdFromRequest);
        String eventIdFromRequest = req.getParameter("eventID");
        Long eventId = new Long(eventIdFromRequest);
        String betSumFromRequest = req.getParameter("betSum");
        BigDecimal betSum = new BigDecimal(betSumFromRequest);
        String winningConditionFromRequest = req.getParameter("winningCondition");
        BetWinningConditionState winningCondition = NOT_APPLIED;
        if (winningConditionFromRequest.equalsIgnoreCase("FOR")) {
            winningCondition = FOR;
        }
        if (winningConditionFromRequest.equalsIgnoreCase("AGAINST")) {
            winningCondition = AGAINST;
        }

        BetCreatorImpl BetCreator = new BetCreatorImpl();
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


