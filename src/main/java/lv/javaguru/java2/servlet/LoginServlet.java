package lv.javaguru.java2.servlet;

import lv.javaguru.java2.domain.LoginService;
import lv.javaguru.java2.domain.LoginServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;



public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        LoginService loginService = new LoginService();

        String url = "login.jsp";
        String message;
        try {
            loginService.login(login, password);
            session.setAttribute("login", login);
            url = "userPage.jsp";
            message = null;
        } catch (LoginServiceException e) {
            message = e.getMessage();
        }
        session.setAttribute("loginMessage", message);
        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);

    }
}
