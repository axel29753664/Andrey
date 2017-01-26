package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.Event;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.services.EventServices;
import lv.javaguru.java2.domain.services.PickEventForBettingService;
import lv.javaguru.java2.domain.services.parsers.ParserStringToLong;
import lv.javaguru.java2.servlet.dto.BetDTO;
import lv.javaguru.java2.servlet.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EventsController {

    @Autowired
    private EventServices eventServices;

    @Autowired
    private PickEventForBettingService pickEventForBettingService;

    @RequestMapping(value = "events", method = RequestMethod.GET)
    public ModelAndView processRequestGet(HttpServletRequest request) {
        List<Event> events = eventServices.getAllEvents();
        return new ModelAndView("events", "eventList", events);
    }

    @RequestMapping(value = "events", method = RequestMethod.POST)
    public ModelAndView processRequestPost(HttpServletRequest request) {
        String eventIdFromRequest = request.getParameter("betEventId");
        Long eventId = ParserStringToLong.parse(eventIdFromRequest);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        BetDTO betDto = new BetDTO();
        betDto.setEventId(eventId);
        betDto.setUserId(user.getUserId());
        ModelAndView model = new ModelAndView();
        model.addObject("betDTOForm", betDto);
        model.setViewName("createBetForm");
        return model;

    }

}
