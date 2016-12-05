package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.domain.RegistrationException;
import lv.javaguru.java2.domain.RegistrationService;
import lv.javaguru.java2.domain.User;

import javax.servlet.http.HttpServletRequest;

public class RegistrationPageController implements MVCController {
    @Override
    public MVCModel processGet(HttpServletRequest req) {
        return new MVCModel("/registration.jsp", req);
    }

    @Override
    public MVCModel processPost(HttpServletRequest req) {
        RegistrationService registration = new RegistrationService();
        User user = new User();
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setLogin(req.getParameter("login"));
        user.setPassword(req.getParameter("password"));
        String message;
        String url = "/registration.jsp";
        try {
            registration.createNewUser(user);
            url = "/java2/login";
            message = null;

        } catch (RegistrationException e) {
            message = e.getMessage();
        }
        req.setAttribute("regMessage", message);
        return new MVCModel(url, req);
    }
}
