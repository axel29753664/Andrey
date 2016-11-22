package lv.javaguru.java2.servlet;

import lv.javaguru.java2.domain.RegistrationException;
import lv.javaguru.java2.domain.RegistrationService;
import lv.javaguru.java2.domain.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        RegistrationService registration = new RegistrationService();
        User user = new User();
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setLogin(req.getParameter("login"));
        user.setPassword(req.getParameter("password"));
        HttpSession session = req.getSession();
        String message;
        String url = "registration.jsp";
        try {
            registration.createNewUser(user);
            url = "login.jsp";
            message = null;

        } catch (RegistrationException e) {
            message = e.getMessage();
        }
        session.setAttribute("regMessage", message);
        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);
    }
}
