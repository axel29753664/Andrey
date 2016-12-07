package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.domain.User;

import javax.servlet.http.HttpServletRequest;

public class UserPageController implements MVCController {
    @Override
    public MVCModel processGet(HttpServletRequest req) {
        return new MVCModel("/userPage.jsp", null);
    }

    @Override
    public MVCModel processPost(HttpServletRequest req) {
        req.getSession().setAttribute("user", null);
        return new MVCModel("/java2/login", null);
    }
}
