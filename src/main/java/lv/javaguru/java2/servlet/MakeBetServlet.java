package lv.javaguru.java2.servlet;

import lv.javaguru.java2.domain.BetCreatorImpl;
import lv.javaguru.java2.domain.BetWinningChoiceState;
import lv.javaguru.java2.domain.ValidationIllegalStateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

import static lv.javaguru.java2.domain.BetWinningChoiceState.AGAINST;
import static lv.javaguru.java2.domain.BetWinningChoiceState.FOR;
import static lv.javaguru.java2.domain.BetWinningChoiceState.NOT_APPLIED;

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
        String winningChoiceFromRequest = req.getParameter("winningChoice");
        BetWinningChoiceState winningChoice = NOT_APPLIED;
        if (winningChoiceFromRequest.equalsIgnoreCase("FOR")) {
            winningChoice = FOR;
        }
        if (winningChoiceFromRequest.equalsIgnoreCase("AGAINST")) {
            winningChoice = AGAINST;
        }

        try {
            BetCreatorImpl BetCreator = new BetCreatorImpl();
            BetCreator.createBet(userId, eventId, betSum, winningChoice);
            req.getRequestDispatcher("makeBetConfirmation.jsp").forward(req, resp);
        } catch (ValidationIllegalStateException e) {
            req.getRequestDispatcher("makeBetError.jsp").forward(req, resp);

        }


    }




}
