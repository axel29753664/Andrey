package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.BetCreator;
import lv.javaguru.java2.domain.BetCreatorImpl;
import lv.javaguru.java2.domain.BetWinningConditionState;
import lv.javaguru.java2.domain.Response;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

import static lv.javaguru.java2.domain.BetWinningConditionState.AGAINST;
import static lv.javaguru.java2.domain.BetWinningConditionState.FOR;
import static lv.javaguru.java2.domain.BetWinningConditionState.NOT_APPLIED;

@Controller
public class MakeBetController {

    @RequestMapping(value = "makeBet", method = {RequestMethod.GET})
    public ModelAndView processRequestGet(HttpServletRequest request) {
        return new ModelAndView("error", "data", "Incorrect request");
    }

    @RequestMapping(value = "makeBet", method = {RequestMethod.POST})
    public ModelAndView processRequestPost(HttpServletRequest request) {

        String userIdFromRequest = request.getParameter("userID");
        String eventIdFromRequest = request.getParameter("eventID");
        String betSumFromRequest = request.getParameter("betSum");
        String winningConditionFromRequest = request.getParameter("winningCondition");

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
            return new ModelAndView("dbErrorMessage", "data", response.getDbError());
        }
        if (response.getErrorsList() != null) {
            return new ModelAndView("makeBetError", "data", response.getErrorsList());
        }
        String data = "Bet is registered with id " + response.getBet().getBetId();
        return new ModelAndView("makeBetConfirmation", "data", data);

    }

}


