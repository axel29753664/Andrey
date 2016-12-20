package lv.javaguru.java2.servlet;

import lv.javaguru.java2.domain.BetCreatorImpl;
import lv.javaguru.java2.domain.BetWinningConditionState;
import lv.javaguru.java2.domain.Response;
import lv.javaguru.java2.domain.betValidation.BetValidationError;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import static lv.javaguru.java2.domain.BetWinningConditionState.AGAINST;
import static lv.javaguru.java2.domain.BetWinningConditionState.FOR;
import static lv.javaguru.java2.domain.BetWinningConditionState.NOT_APPLIED;

public class MakeBetServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {


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
        if (response.getBet() != null) {
            req.setAttribute("betId", response.getBet().getBetId());
            req.setAttribute("userId", response.getBet().getUserId());
            req.setAttribute("eventId", response.getBet().getEventId());
            req.setAttribute("betSum", response.getBet().getBetSum());
            req.setAttribute("winningCondition", response.getBet().getWinningCondition());
            req.getRequestDispatcher("makeBetConfirmation.jsp").forward(req, resp);
        }
        if (response.getDbError() != null) {
            req.setAttribute("Error message", response.getDbError());
            req.getRequestDispatcher("dbErrorMessage.jsp").forward(req, resp);
        }
        if (response.getErrorsList() != null) {
            req.setAttribute("Errors", response.getErrorsList());
            req.getRequestDispatcher("makeBetError.jsp").forward(req, resp);
        }

    }


}
