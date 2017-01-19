package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.services.BetManagementService;
import lv.javaguru.java2.domain.services.BetService;
import lv.javaguru.java2.servlet.dto.BetDto;
import lv.javaguru.java2.servlet.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "admin")
public class BetManagementController {

    @Autowired
    private BetManagementService betManagementService;

    @Autowired
    private BetService betService;

    @RequestMapping(value = "betManagement", method = {RequestMethod.GET})
    public ModelAndView processRequestGet(HttpServletRequest request) {
        List<UserDto> usersDto = betManagementService.prepareUserList();
        return new ModelAndView("adminPages/betManagement", "data", usersDto);
    }

    @RequestMapping(value = "betManagement", method = {RequestMethod.POST})
    public ModelAndView processRequestPost(HttpServletRequest request) {
        String userIdFromRequest = request.getParameter("userIdForBetDeleting");
        UserDto userDto = new UserDto(userIdFromRequest);
        List<BetDto> betsDto = betManagementService.managementProcess(userDto);
        HttpSession session = request.getSession();
        session.setAttribute("userForBetDeleting", userDto);
        return new ModelAndView("adminPages/betDeleting", "data", betsDto);
    }

}