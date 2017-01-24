package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.Event;
import lv.javaguru.java2.domain.WinnerStatus;
import lv.javaguru.java2.domain.services.EventServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;

@Controller
@RequestMapping(value = "admin")
public class ManageAllEventsController {
    @Autowired
    private EventServices eventServices;

    @RequestMapping(value = "allEvents", method = RequestMethod.GET)
    public ModelAndView eventManagementProcessGet() {

        List<Event> eventList = eventServices.getEventsWhereWinnerStatusNotSet();
        ModelAndView model = new ModelAndView();
        model.addObject("eventList", eventList);
        modelAddEventAndWinnerStates(model);
        model.setViewName("adminPages/allEvents");
        return model;
    }

    @RequestMapping(value = "allEvents", method = RequestMethod.POST)
    public ModelAndView processRequestPost(HttpServletRequest request, ModelAndView model) {
        String buttonPressed = request.getParameter("buttonPressed");
        int eventListSize = Integer.parseInt(request.getParameter("eventListSize"));

        if ((buttonPressed != null) && (!buttonPressed.equals(""))) {
            if (buttonPressed.equals("delete")) {
                for (int i = 0; i < eventListSize; i++) {
                    String result = request.getParameter(String.valueOf(i));  // get deleted Event id from checkbox
                    if (result != null) {
                        Long id = Long.parseLong(result);
                        eventServices.delete(id);
                    }
                }

            } else {
                if (buttonPressed.equals("update")) {
                    for (int i = 0; i < eventListSize; i++) {
                        String result = request.getParameter(String.valueOf(i));  // get updated Event id from checkbox
                        if (result != null) {
                            Long id = Long.parseLong(result);
                            //@Transactional
                            Event event = eventServices.getEventById(id);
                            WinnerStatus winnerStatus = WinnerStatus.valueOf(request.getParameter("winner" + id));
                            event.setWinnerStatus(winnerStatus);
                            eventServices.updateEvent(event);
                            //send money to winners from total bank
                            //Transaction end
                        }
                    }
                }
            }
        }
        List<Event> eventList = eventServices.getEventsWhereWinnerStatusNotSet();
        model.addObject("eventList", eventList);

        modelAddEventAndWinnerStates(model);
        model.setViewName("adminPages/allEvents");
        return model;
    }

    private void modelAddEventAndWinnerStates(ModelAndView model) {
        model.addObject("winner", WinnerStatus.values());
    }
}
