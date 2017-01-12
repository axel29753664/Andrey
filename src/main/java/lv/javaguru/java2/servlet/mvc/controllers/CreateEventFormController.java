package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.Event;
import lv.javaguru.java2.domain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CreateEventFormController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "createEventForm", method = RequestMethod.GET)
    public ModelAndView processRequestGet(HttpServletRequest request) {
        return new ModelAndView("createEventForm");
    }

    @RequestMapping(value = "createEventForm", method = RequestMethod.POST)
    public ModelAndView processRequestPost(HttpServletRequest request) {
        Event event = new Event();
        event.setEventName(request.getParameter("eventName"));
        event.setEventDescription(request.getParameter("eventDescription"));
        event.setWinningCondition(request.getParameter("winningCondition"));
        event.setLoseCondition(request.getParameter("loseCondition"));
        event.setDrawCondition(request.getParameter("drawCondition"));
        userService.createEvent(event);
        return new ModelAndView("createEventConfirmation", "event", event);
    }

}
