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
@RequestMapping(value = "admin")
public class BetsDeletingController {

    @Autowired
    private BetService betService;

    @RequestMapping(value = "betsDeleting", method = {RequestMethod.GET})
    public ModelAndView processRequestGet(HttpServletRequest request) {
        return new ModelAndView("error", "data", "Incorrect request");
    }

    @RequestMapping(value = "betsDeleting", method = {RequestMethod.POST})
    public ModelAndView processRequestPost(HttpServletRequest request) {
        String deletedBetIdFromRequest = request.getParameter("deletingBetId");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if ((deletedBetIdFromRequest != null) && (!deletedBetIdFromRequest.equals(""))) {
            Long deletingBetId = Long.parseLong(deletedBetIdFromRequest);
            betService.deleteBetById(deletingBetId);
        }
        List<Bet> bets = betService.getBetsByUserId(user.getUserId());
        return new ModelAndView("adminPages/betsDeleting", "data", bets);
    }

}
