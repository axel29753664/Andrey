package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.Event;
import lv.javaguru.java2.domain.services.EventServices;
import lv.javaguru.java2.domain.services.PickEventForBettingService;
import lv.javaguru.java2.domain.services.UserService;
import lv.javaguru.java2.servlet.dto.BetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
        BetDto betDto = new BetDto();
        betDto.setEventId(eventIdFromRequest);



    }



    /*@RequestMapping(value = "events", method = RequestMethod.POST)
    public ModelAndView processRequestPost(HttpServletRequest request) {
        String betEventId = request.getParameter("betEventId");
        Long eventId = null;
        if ((betEventId != null) && (!betEventId.equals(""))) {
            eventId = Long.parseLong(betEventId);
        }
        Event event = eventServices.getEventById(eventId);

        return new ModelAndView("createBetForm", "event", event);
    }*/

}
