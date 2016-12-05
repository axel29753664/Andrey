package lv.javaguru.java2.servlet.mvc;

import javax.servlet.http.HttpServletRequest;

public class UserPageController implements MVCController {
    @Override
    public MVCModel processGet(HttpServletRequest req) {
        return new MVCModel("/userPage.jsp", req);
    }

    @Override
    public MVCModel processPost(HttpServletRequest req) {
        req.getSession().setAttribute("login", null);
        return new MVCModel("/java2/login", null);
    }
}
