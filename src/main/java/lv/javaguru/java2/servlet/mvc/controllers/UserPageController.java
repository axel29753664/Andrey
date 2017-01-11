package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.services.LoginService;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
public class UserPageController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "userPage", method = {RequestMethod.GET})
    public ModelAndView processRequestGet(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        String url = loginService.getRightPageByUserLogin(user.getLogin());
        return new ModelAndView(url);
    }

    @RequestMapping(value = "userPage", method = {RequestMethod.POST})
    public ModelAndView processRequestPost(HttpServletRequest request) {
        request.getSession().setAttribute("user", null);
        return new ModelAndView("redirect", "url", "login");
    }
}
