package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.BetConditionState;
import lv.javaguru.java2.domain.Event;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.exception.EventCreationException;
import lv.javaguru.java2.domain.services.EventServices;
import lv.javaguru.java2.domain.services.UserService;
import lv.javaguru.java2.domain.services.factories.CreationFactory;
import lv.javaguru.java2.servlet.dto.BetDTO;
import lv.javaguru.java2.servlet.dto.EventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private EventServices eventServices;


    @RequestMapping(value = "createEventForm", method = RequestMethod.GET)
    public ModelAndView processRequestGet(ModelAndView model) {
        EventDTO eventDTO = new EventDTO();
        BetDTO betDTO = new BetDTO();
        model.addObject("eventDTO", eventDTO);
        model.addObject("betDTO", betDTO);
        return model;
    }

    @RequestMapping(value = "createEventForm", method = RequestMethod.POST)
    public ModelAndView processRequestPost(@Valid @ModelAttribute EventDTO eventDTO, BindingResult eventErrors,
                                           @Valid @ModelAttribute BetDTO betDTO,
                                           BindingResult betErrors, ModelAndView model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if ((!eventErrors.hasErrors()) && (!betErrors.hasErrors())) {
            try {
                eventServices.createEvent(user.getUserId(), eventDTO, eventErrors, betDTO, betErrors);
                model.setViewName("createEventConfirmation");
                model.addObject("event", eventDTO);
            } catch (EventCreationException e) {
                /*error*/
            }
        }
        return model;
    }

}
