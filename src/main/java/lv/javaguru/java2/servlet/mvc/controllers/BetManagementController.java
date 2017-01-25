package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.services.BetManagementService;
import lv.javaguru.java2.domain.services.parsers.ParserStringToLong;
import lv.javaguru.java2.servlet.dto.BetDTO;
import lv.javaguru.java2.servlet.dto.UserDTO;
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

    @RequestMapping(value = "betManagement", method = {RequestMethod.GET})
    public ModelAndView processRequestGet(HttpServletRequest request) {
        List<UserDTO> usersDto = betManagementService.prepareUserList();
        return new ModelAndView("adminPages/betManagement", "data", usersDto);
    }

    @RequestMapping(value = "betManagement", method = {RequestMethod.POST})
    public ModelAndView processRequestPost(HttpServletRequest request) {
        String userIdFromRequest = request.getParameter("userIdForBetDeleting");
        Long userId = ParserStringToLong.parse(userIdFromRequest);
        UserDTO userDTO = new UserDTO(userId);
        List<BetDTO> betsDto = betManagementService.managementProcess(userDTO);
        HttpSession session = request.getSession();
        session.setAttribute("userForBetDeleting", userDTO);
        return new ModelAndView("adminPages/betDeleting", "data", betsDto);
    }

}