package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.*;
import lv.javaguru.java2.domain.exception.RegistrationException;
import lv.javaguru.java2.domain.services.RegistrationService;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegistrationPageController {
    @Autowired
    private RegistrationService registration;

    @RequestMapping(value = "registration", method = {RequestMethod.GET})
    public ModelAndView processGet(HttpServletRequest request) {
        return new ModelAndView("registration");
    }

    @RequestMapping(value = "registration", method = {RequestMethod.POST})
    public ModelAndView processPost(HttpServletRequest request) {

        User user = new User();
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));
        String message;
        String url = "registration";
        try {
            registration.createNewUser(user);
            url = "login";
            message = "Registration successful ! Please login.";
        } catch (RegistrationException e) {
            message = e.getMessage();
        }
        return new ModelAndView(url, "message", message);
    }
}
