package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.services.AdminService;
import lv.javaguru.java2.domain.services.LoginService;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.h2.engine.Session;
import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

@Component
public class AdminPageController implements MVCController {
    @Autowired
    private AdminService adminService;
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

        Enumeration en = req.getParameterNames();
        while (en.hasMoreElements()) {
            String name = (String) en.nextElement();
            System.out.println(" name : " + name);
            String value = req.getParameter(name);
            System.out.println(" value : " + value);
            String[] values = req.getParameterValues(name);

            for (int i = 0; i < values.length; i++) {
                System.out.println("Values " + values[i]);
            }
        }
        List<User> users = adminService.getAllUsers();
        return new MVCModel("/adminPage.jsp", users);
    }
}
