package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.exception.LoginValidationException;
import lv.javaguru.java2.domain.services.LoginService;
import lv.javaguru.java2.domain.exception.LoginServiceException;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginPageController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "login", method = {RequestMethod.GET})
    public ModelAndView processRequestGet(HttpServletRequest request) {
        return new ModelAndView("login");
    }


    @RequestMapping(value = "login", method = {RequestMethod.POST})
    public ModelAndView processPost(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        String url = "login";
        String message;

        try {
            User user = loginService.login(login, password);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            url = loginService.getRightPageByUserLogin(user.getLogin());
            message = null;
            return new ModelAndView("redirect", "url", url);
        } catch (LoginValidationException | LoginServiceException e) {
            message = e.getMessage();
        }
        return new ModelAndView(url, "message", message);

    }
}
