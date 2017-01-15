package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.services.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import lv.javaguru.java2.domain.services.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BetsManagementController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private BetService betService;

    @RequestMapping(value = "betsManagement", method = {RequestMethod.GET})
    public ModelAndView processRequestGet(HttpServletRequest request) {
        List<User> users = adminService.getAllUsers();
        return new ModelAndView("betsManagement", "data", users);
    }

    @RequestMapping(value = "betsManagement", method = {RequestMethod.POST})
    public ModelAndView processRequestPost(HttpServletRequest request) {
        String userIdFromRequest = request.getParameter("userBetsId");
        Long userId = null;
        if ((userIdFromRequest != null) && (!userIdFromRequest.equals(""))) {
            userId = Long.parseLong(userIdFromRequest);
        }
        List<Bet> bets = betService.getBetsByUserId(userId);
        HttpSession session = request.getSession();
        session.setAttribute("userIdForBetDeleting", userId);
        return new ModelAndView("betsDeleting", "data", bets);
    }

}

