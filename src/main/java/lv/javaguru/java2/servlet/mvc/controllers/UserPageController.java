package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


@Component
public class UserPageController implements MVCController {

    @Override
    public MVCModel processGet(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        String url = "/login.jsp";
        if (user.getLogin() != null) {
            url = "/userPage.jsp";
        }
        return new MVCModel(url, null);
    }

    @Override
    public MVCModel processPost(HttpServletRequest req) {
        req.getSession().setAttribute("user", null);
        return new MVCModel("/login.jsp", null);
    }
}
