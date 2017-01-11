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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

@Controller
public class AdminPageController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "adminPage", method = {RequestMethod.GET})
    public ModelAndView processRequestGet(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        String url = loginService.getRightPageByUserLogin(user.getLogin());
        return new ModelAndView(url);
    }

    @RequestMapping(value = "adminPage", method = {RequestMethod.POST})
    public ModelAndView processRequestPost(HttpServletRequest request) {
        String deletedUserId = request.getParameter("deletedUserId");
        if ((deletedUserId != null) && (!deletedUserId.equals(""))) {
            Long id = Long.parseLong(deletedUserId);
            adminService.deleteUserById(id);
        }
        List<User> users = adminService.getAllUsers();
        return new ModelAndView("adminPage", "data", users);
    }
}
