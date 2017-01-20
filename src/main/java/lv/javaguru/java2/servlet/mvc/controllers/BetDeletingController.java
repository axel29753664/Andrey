package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.services.BetDeletingService;
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
public class BetDeletingController {

    @Autowired
    private BetDeletingService betDeletingService;

    @RequestMapping(value = "betDeleting", method = {RequestMethod.GET})
    public ModelAndView processRequestGet(HttpServletRequest request) {
        return new ModelAndView("error", "data", "Incorrect request");
    }

    @RequestMapping(value = "betDeleting", method = {RequestMethod.POST})
    public ModelAndView processRequestPost(HttpServletRequest request) {
        String betIdFromRequest = request.getParameter("betIdForDeleting");
        BetDto betDto = new BetDto(betIdFromRequest);
        HttpSession session = request.getSession();
        UserDto userForBetDeleting = (UserDto) session.getAttribute("userForBetDeleting");
        List<BetDto> betsDto = betDeletingService.deletingProcess(betDto, userForBetDeleting);
        return new ModelAndView("adminPages/betDeleting", "data", betsDto);
    }

}
