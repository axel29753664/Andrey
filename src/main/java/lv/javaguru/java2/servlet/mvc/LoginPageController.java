package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.domain.LoginService;
import lv.javaguru.java2.domain.LoginServiceException;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Component
public class LoginPageController implements MVCController {

    @Autowired private LoginService loginService;
    @Override
    public MVCModel processGet(HttpServletRequest req) {
        return new MVCModel("/login.jsp", null);
    }


    @Override
    public MVCModel processPost(HttpServletRequest req) {
        String login = req.getParameter("login");
        String password = req.getParameter("password");


        String url = "/login.jsp";
        String message;
        try {
            User user = loginService.login(login, password);
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            url = "/userPage.jsp";
            message = null;
        } catch (LoginServiceException e) {
            message = e.getMessage();
        }
        req.setAttribute("loginMessage", message);
        return new MVCModel(url, null);

    }
}
