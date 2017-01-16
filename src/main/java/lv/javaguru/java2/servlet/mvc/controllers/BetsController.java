package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.services.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BetsController {

    @Autowired
    private BetService betService;

    @RequestMapping(value = "bets", method = RequestMethod.GET)
    public ModelAndView processRequestGet(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        List<Bet> bets = betService.getBetsByUserId(user.getUserId());
        return new ModelAndView("bets", "data", bets);
    }

    @RequestMapping(value = "bets", method = {RequestMethod.POST})
    public ModelAndView processRequestPost(HttpServletRequest request) {
        return new ModelAndView("error", "data", "Incorrect request");
    }

}