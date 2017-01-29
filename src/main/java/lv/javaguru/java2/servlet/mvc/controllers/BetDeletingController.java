package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.services.BetListService;
import lv.javaguru.java2.domain.services.parsers.ParserStringToLong;
import lv.javaguru.java2.servlet.dto.BetDTO;
import lv.javaguru.java2.servlet.dto.EventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "admin")
public class BetDeletingController {

    @Autowired
    private BetListService betListService;

    @RequestMapping(value = "betDeleting", method = {RequestMethod.GET})
    public ModelAndView processRequestGet(HttpServletRequest request) {
        return new ModelAndView("error", "data", "Incorrect request");
    }

    @RequestMapping(value = "betDeleting", method = {RequestMethod.POST})
    public ModelAndView processRequestPost(HttpServletRequest request) {
        String betIdFromRequest = request.getParameter("betIdForDeleting");
        Long betId = ParserStringToLong.parse(betIdFromRequest);
        List<BetDTO> betsDTO = betListService.deletingProcess(betId);
        List<EventDTO> eventsDTO = betListService.prepareEventList(betsDTO);
        ModelAndView model = new ModelAndView();
        model.addObject("betsDTO", betsDTO);
        model.addObject("eventsDTO", eventsDTO);
        model.setViewName("adminPages/betDeleting");
        return model;
    }

}