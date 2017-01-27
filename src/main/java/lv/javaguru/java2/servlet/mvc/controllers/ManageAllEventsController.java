package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.Event;
import lv.javaguru.java2.domain.services.EventServices;
import lv.javaguru.java2.servlet.mvc.controllers.controllerServices.ButtonProcessMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping(value = "admin")
public class ManageAllEventsController {
    @Autowired
    private ButtonProcessMenu buttonProcessMenu;
    @Autowired
    private EventServices eventServices;
    private boolean eventListSwitch;


    @RequestMapping(value = {"activeEvents", "allEvents"}, method = RequestMethod.GET)
    public ModelAndView eventManagementProcessGet(HttpServletRequest request) {
        String path = request.getServletPath();
        initSwitcher(path);

        List<Event> eventList = getEventList();
        ModelAndView model = new ModelAndView();
        model.addObject("eventList", eventList);
        model.setViewName("adminPages/allEvents");
        return model;
    }

    @RequestMapping(value = "activeEvents", method = RequestMethod.POST)
    public ModelAndView processRequestPost(HttpServletRequest request, ModelAndView model) {
        String buttonPressed = request.getParameter("buttonPressed");
        String listSizeFromRequest = request.getParameter("eventListSize");

        int eventListSize = Integer.parseInt(listSizeFromRequest);
        buttonProcessMenu.getButtonProcess(buttonPressed).doAction(request, eventListSize, eventServices);

        List<Event> eventList = getEventList();
        model.addObject("eventList", eventList);

        model.setViewName("adminPages/allEvents");
        return model;
    }


    private void initSwitcher(String path) {
        eventListSwitch = path.equals("/admin/allEvents");
    }

    private List<Event> getEventList() {
        if (eventListSwitch) {
            return eventServices.getAllEvents();
        } else {
            return eventServices.getEventsWhereWinnerStatusNotSet();
        }
    }

}
