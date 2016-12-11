package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.domain.LoginValidationException;
import lv.javaguru.java2.domain.RegistrationException;
import lv.javaguru.java2.domain.RegistrationService;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
@Component
public class RegistrationPageController implements MVCController {
    @Autowired
    private RegistrationService registration;
    @Override
    public MVCModel processGet(HttpServletRequest req) {
        return new MVCModel("/registration.jsp", null);
    }

    @Override
    public MVCModel processPost(HttpServletRequest req) {

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

        } catch (LoginValidationException | RegistrationException e) {
            message = e.getMessage();
        }

        req.setAttribute("regMessage", message);
        return new MVCModel(url, null);
    }
}