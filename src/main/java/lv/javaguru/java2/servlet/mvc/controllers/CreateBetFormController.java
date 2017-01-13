package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.BetCreator;
import lv.javaguru.java2.domain.BetWinningConditionState;
import lv.javaguru.java2.domain.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

@Controller
public class CreateBetFormController {

    @Autowired
    private BetCreator betCreator;

    @RequestMapping(value = "createBetForm", method = {RequestMethod.GET})
    public ModelAndView processRequestGet(HttpServletRequest request) {
        return new ModelAndView("error", "data", "Incorrect request");
    }

    @RequestMapping(value = "createBetForm", method = {RequestMethod.POST})
    public ModelAndView processRequestPost(HttpServletRequest request) {

        String userIdFromRequest = request.getParameter("userID");
        String eventIdFromRequest = request.getParameter("eventID");
        String betSumFromRequest = request.getParameter("betSum");
        String betConditionFromRequest = request.getParameter("betCondition");

        Long userId = null;
        Long eventId = null;
        BigDecimal betSum = null;
        BetWinningConditionState betCondition = BetWinningConditionState.NOT_APPLIED;

        if ((userIdFromRequest != null) && (!userIdFromRequest.equals(""))) {
            userId = Long.parseLong(userIdFromRequest);
        }
        if ((eventIdFromRequest != null) && (!eventIdFromRequest.equals(""))) {
            eventId = Long.parseLong(eventIdFromRequest);
        }
        if ((betSumFromRequest != null) && (!betSumFromRequest.equals(""))) {
            betSum = BigDecimal.valueOf(Long.parseLong(betSumFromRequest));
        }
        if ((betConditionFromRequest != null) && (!betConditionFromRequest.equals(""))) {
            if (betConditionFromRequest.equals("WIN")) {
                betCondition = BetWinningConditionState.WIN;
            }
            if (betConditionFromRequest.equals("LOSE")) {
                betCondition = BetWinningConditionState.LOSE;
            }
            if (betConditionFromRequest.equals("DRAW")) {
                betCondition = BetWinningConditionState.DRAW;
            }
        }


        Response response = betCreator.createBet(userId, eventId, betSum, betCondition);

        if (response.getDbError() != null) {
            return new ModelAndView("createBetError", "data", response.getDbError());
        }
        if (response.getErrorsList() != null) {
            return new ModelAndView("createBetError", "data", response.getErrorsList());
        }
        //String data = "Bet is registered with id " + response.getBet().getBetId();
        return new ModelAndView("createBetConfirmation", "data", response.getBet());

    }

}