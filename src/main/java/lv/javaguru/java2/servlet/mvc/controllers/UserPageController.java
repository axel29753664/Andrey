package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
public class UserPageController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "userPage", method = {RequestMethod.GET})
    public ModelAndView processRequestGet(HttpServletRequest request) {
        return new ModelAndView("userPage");
    }

    @RequestMapping(value = "userPage", method = {RequestMethod.POST})
    public ModelAndView processRequestPost(HttpServletRequest request) {

        return new ModelAndView("userPage");
    }
}
