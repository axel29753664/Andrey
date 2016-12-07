package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.domain.LoginService;
import lv.javaguru.java2.domain.LoginServiceException;
import lv.javaguru.java2.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginPageController implements MVCController {
    @Override
    public MVCModel processGet(HttpServletRequest req) {
        return new MVCModel("/login.jsp", null);
    }


    @Override
    public MVCModel processPost(HttpServletRequest req) {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        LoginService loginService = new LoginService();

        String url = "/login.jsp";
        String message;
        try {
            User user = loginService.login(login, password);
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            url = "/java2/userPage";
            message = null;
        } catch (LoginServiceException e) {
            message = e.getMessage();
        }
        req.setAttribute("loginMessage", message);
        return new MVCModel(url, null);

    }
}
