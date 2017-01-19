package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.services.factories.UserFactory;
import lv.javaguru.java2.domain.validators.UserValidator;
import lv.javaguru.java2.servlet.dto.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller

public class RegistrationController {

    @Autowired
    private UserFactory userFactory;

    @RequestMapping(value = "registration",method = {RequestMethod.GET})
    public ModelAndView processGet(ModelAndView model) {
        UserDTO userDTO = new UserDTO();
        model.addObject("userDTOForm", userDTO);
        model.setViewName("registration");
        return model;
    }


    @RequestMapping(value = "registration",method = RequestMethod.POST)
    public ModelAndView processPost(@Valid @ModelAttribute("userDTOForm") UserDTO userDTO,
                                    BindingResult result, ModelAndView model) {
        if (!result.hasErrors()) {
            userFactory.create(userDTO, result);
            if (!result.hasErrors()) {
                model.setViewName("registrationSuccess");
            }
        }
        return model;
    }

}
