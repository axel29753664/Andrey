package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.BetConditionState;
import lv.javaguru.java2.domain.Event;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.services.EventServices;
import lv.javaguru.java2.domain.services.PickEventForBettingService;
import lv.javaguru.java2.domain.services.dtoConverters.ConverterEventDTO;
import lv.javaguru.java2.domain.services.parsers.ParserStringToLong;
import lv.javaguru.java2.servlet.dto.BetDTO;
import lv.javaguru.java2.servlet.dto.EventDTO;
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

    @Autowired
    private ConverterEventDTO converterEventDTO;

    @RequestMapping(value = "events", method = RequestMethod.GET)
    public ModelAndView processRequestGet(HttpServletRequest request) {
        List<Event> events = eventServices.getAllEvents();
        return new ModelAndView("events", "eventList", events);
    }

    @RequestMapping(value = "events", method = RequestMethod.POST)
    public ModelAndView processRequestPost(HttpServletRequest request) {
        String eventIdFromRequest = request.getParameter("betEventId");
        Long eventId = ParserStringToLong.parse(eventIdFromRequest);
        Event event = eventServices.getEventById(eventId);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        BetDTO betDTO = new BetDTO();
        betDTO.setEventId(eventId);
        betDTO.setUserId(user.getUserId());
        EventDTO eventDTO = converterEventDTO.convertToResponse(event);
        ModelAndView model = new ModelAndView();
        //model.addObject("eventDTO", eventDTO);
        if (event.getBetSide() == BetConditionState.WIN) {
            betDTO.setBetCondition(BetConditionState.WIN);
        }
        if (event.getBetSide() == BetConditionState.LOSE) {
            betDTO.setBetCondition(BetConditionState.LOSE);
        }
        //if (event.getBetSide() == BetConditionState.NOT_SET) {
        //    betDTO.setBetCondition(BetConditionState.NOT_SET);
        //}
        model.addObject("betDTO", betDTO);
        model.setViewName("createBetForm");
        return model;
    }

}
