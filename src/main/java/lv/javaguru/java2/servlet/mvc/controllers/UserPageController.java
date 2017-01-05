package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.services.LoginService;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


@Component
public class UserPageController implements MVCController {
    @Autowired
    private LoginService loginService;

    @Override
    public MVCModel processGet(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        String url = loginService.getRightPageByUserLogin(user.getLogin());
        return new MVCModel(url, null);
    }

    @Override
    public MVCModel processPost(HttpServletRequest req) {
        req.getSession().setAttribute("user", null);
        return new MVCModel("/login.jsp", null);
    }
}
