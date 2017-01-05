package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.exception.LoginValidationException;
import lv.javaguru.java2.domain.services.LoginService;
import lv.javaguru.java2.domain.exception.LoginServiceException;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
public class LoginPageController implements MVCController {

    @Autowired
    private LoginService loginService;

    @Override
    public MVCModel processGet(HttpServletRequest req) {
        return new MVCModel("/login.jsp", null);
    }


    @Override
    public MVCModel processPost(HttpServletRequest req) {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        String url = "/login.jsp";
        String message = null;

        try {
            User user = loginService.login(login, password);
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            url = loginService.getRightPageByUserLogin(user.getLogin());
            message = null;
        } catch (LoginValidationException | LoginServiceException e) {
            message = e.getMessage();
        }
        req.setAttribute("loginMessage", message);
        return new MVCModel(url, null);

    }
}
