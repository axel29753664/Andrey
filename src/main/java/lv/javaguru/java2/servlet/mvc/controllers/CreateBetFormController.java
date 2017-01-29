package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.Event;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.services.ApplyBetService;
import lv.javaguru.java2.domain.services.EventServices;
import lv.javaguru.java2.domain.services.UserService;
import lv.javaguru.java2.domain.services.dtoConverters.ConverterEventDTO;
import lv.javaguru.java2.domain.services.dtoConverters.ConverterUserDTO;
import lv.javaguru.java2.servlet.dto.BetDTO;
import lv.javaguru.java2.servlet.dto.EventDTO;
import lv.javaguru.java2.servlet.dto.UserDTO;
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
public class CreateBetFormController {

    @Autowired
    private ApplyBetService applyBetService;

    @Autowired
    private EventServices eventServices;

    @Autowired
    private UserService userServices;

    @Autowired
    private ConverterEventDTO converterEventDTO;

    @Autowired
    private ConverterUserDTO converterUserDTO;


    @RequestMapping(value = "createBetForm", method = {RequestMethod.GET})
    public ModelAndView processRequestGet() {
        return new ModelAndView("error", "data", "Incorrect request");
    }

    @RequestMapping(value = "createBetForm", method = {RequestMethod.POST})
    public ModelAndView processRequestPost(@Valid @ModelAttribute("betDTO") BetDTO betDTO,
                                           BindingResult validResult, ModelAndView model) {

        if (!validResult.hasErrors()) {
            applyBetService.apply(betDTO, validResult);
            if (!validResult.hasErrors()) {
                Event event = eventServices.getEventById(betDTO.getEventId());
                User user = userServices.getById(betDTO.getUserId());
                UserDTO userDTO = converterUserDTO.convertToResponse(user);
                EventDTO eventDTO = converterEventDTO.convertToResponse(event);
                model.addObject("betDTO", betDTO);
                model.addObject("userDTO", userDTO);
                model.addObject("eventDTO", eventDTO);
                model.setViewName("createBetConfirmation");
            }
        }

        return model;

    }

}