package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.services.LoginService;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
//@RequestMapping(value = "user")
//@Secured({"ROLE_USER","ROLE_ADMIN"})
public class UserPageController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "userPage", method = {RequestMethod.GET})
    public ModelAndView processRequestGet(HttpServletRequest request) {
        return new ModelAndView("userPage");
    }

    @RequestMapping(value = "userPage", method = {RequestMethod.POST})
    public ModelAndView processRequestPost(HttpServletRequest request) {
//        request.getSession().setAttribute("user", null);
        return new ModelAndView("userPage");
    }
}
