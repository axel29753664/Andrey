package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.Bet;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.services.BetService;
import lv.javaguru.java2.domain.services.dtoConverters.ConverterDtoList;
import lv.javaguru.java2.servlet.dto.BetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired
    private ConverterDtoList converterDtoList;

    @RequestMapping(value = "bets", method = RequestMethod.GET)
    public ModelAndView processRequestGet(HttpServletRequest request) {
        User user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Bet> bets = betService.getBetsByUserId(user.getUserId());
        List<BetDto> betsDto = converterDtoList.convertBetListToResponse(bets);
        return new ModelAndView("bets", "data", betsDto);
    }

    @RequestMapping(value = "bets", method = {RequestMethod.POST})
    public ModelAndView processRequestPost(HttpServletRequest request) {
        return new ModelAndView("error", "data", "Incorrect request");
    }

}