package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.services.BetService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class BetListController {

    @Autowired
    BetService betService;

    @RequestMapping(value = {"allBets", "activeBets"}, method = RequestMethod.GET)
    public ModelAndView processRequestGet(HttpServletRequest request) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String path = request.getServletPath();

        ModelAndView model = new ModelAndView();
        List<Bet> bets = getUserBets(path, user.getUserId());
        model.addObject("bets", bets);

        model.setViewName("betList");
        return model;
    }

    @RequestMapping(value = "bets", method = RequestMethod.GET)
    public ModelAndView processBetsGet() {
        return new ModelAndView("bets");
    }

    private List<Bet> getUserBets(String path, Long userId) {
        if (path.equals("/activeBets")) {
            return betService.getUserActiveBets(userId);
        }
        return betService.getBetsByUserId(userId);
    }

}