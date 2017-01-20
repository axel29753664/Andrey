package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.Event;
import lv.javaguru.java2.domain.services.EventServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "admin")
public class ManageAllEventsController {
    @Autowired
    private EventServices eventServices;

    @RequestMapping(value = "allEvents", method = RequestMethod.GET)
    public ModelAndView eventManagementProcessGet() {
        List<Event> events = eventServices.getAllEvents();
        return new ModelAndView("adminPages/allEvents", "eventList", events);
    }

    @RequestMapping(value = "allEvents", method = RequestMethod.POST)
    public ModelAndView processRequestPost(HttpServletRequest request, ModelAndView model) {
        String deletedEventId = request.getParameter("deletedEventId");

        if ((deletedEventId != null) && (!deletedEventId.equals(""))) {
            Long eventId = Long.parseLong(deletedEventId);
            eventServices.delete(eventId);
            List<Event> eventList = eventServices.getAllEvents();
            model.addObject("eventList", eventList);
        }
        model.setViewName("adminPages/allEvents");
        return model;
    }
}
