package lv.javaguru.java2.servlet.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.security.Principal;

@Controller
public class AccessDeniedPageController {
    @RequestMapping(value = "accessDenied", method = RequestMethod.GET)
    public ModelAndView processRequestGet(Principal user) {
        ModelAndView model = new ModelAndView();
        model.setViewName("accessDenied");

        model.addObject("message", user.getName() + ", you do not have permission to access this page!");

        return model;
    }
}
