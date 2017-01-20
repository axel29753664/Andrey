package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.Event;
import lv.javaguru.java2.domain.services.UserService;
import lv.javaguru.java2.domain.services.factories.CreationFactory;
import lv.javaguru.java2.servlet.dto.EventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class CreateEventFormController {
    @Autowired
    private CreationFactory<EventDTO> eventCreationFactory;


    @RequestMapping(value = "createEventForm", method = RequestMethod.GET)
    public ModelAndView processRequestGet(ModelAndView model) {
        EventDTO eventDTO = new EventDTO();
        model.addObject("eventDTO", eventDTO);
        return model;
    }

    @RequestMapping(value = "createEventForm", method = RequestMethod.POST)
    public ModelAndView processRequestPost(@Valid @ModelAttribute EventDTO eventDTO, BindingResult result, ModelAndView model) {

        if (!result.hasErrors()) {
            eventCreationFactory.create(eventDTO, result);
            if (!result.hasErrors()) {
                model.setViewName("createEventConfirmation");
                model.addObject("event", eventDTO);
            }
        }
        return model;
    }

}
