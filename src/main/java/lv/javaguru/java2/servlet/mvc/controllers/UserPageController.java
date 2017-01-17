package lv.javaguru.java2.servlet.mvc.controllers;


import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;


@Controller
public class UserPageController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "userPage", method = {RequestMethod.GET})
    public ModelAndView processRequestGet(Principal principal) {

//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return new ModelAndView("userPage");
    }

    @RequestMapping(value = "userPage", method = {RequestMethod.POST})
    public ModelAndView processRequestPost(HttpServletRequest request) {

        return new ModelAndView("userPage");
    }
}
