package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.services.BetListService;
import lv.javaguru.java2.servlet.dto.BetDTO;
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
    private BetListService betListService;

    @RequestMapping(value = "betList", method = RequestMethod.GET)
    public ModelAndView processRequestGet(HttpServletRequest request) {
        User user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<BetDTO> betsDto = betListService.prepareBetList(user);
        return new ModelAndView("betList", "data", betsDto);
    }

    @RequestMapping(value = "betList", method = {RequestMethod.POST})
    public ModelAndView processRequestPost(HttpServletRequest request) {
        return new ModelAndView("error", "data", "Incorrect request");
    }

}