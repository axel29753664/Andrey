package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.services.BetDeletingService;
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
        Long betId = ParserStringToLong.parse(betIdFromRequest);
        BetDTO betDto = new BetDTO();
        betDto.setBetId(betId);
        HttpSession session = request.getSession();
        UserDTO userForBetDeleting = (UserDTO) session.getAttribute("userForBetDeleting");
        List<BetDTO> betsDto = betDeletingService.deletingProcess(betDto, userForBetDeleting);
        return new ModelAndView("adminPages/betDeleting", "data", betsDto);
    }

}
