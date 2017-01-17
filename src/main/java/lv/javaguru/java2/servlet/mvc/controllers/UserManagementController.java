package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "admin")
public class UserManagementController {
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "userManagement", method = RequestMethod.GET)
    public ModelAndView processMethodGet() {
        ModelAndView model = new ModelAndView();
        List<User> users = getUserList();
        model.addObject("users", users);
        model.setViewName("adminPages/userManagement");

        return model;
    }

    @RequestMapping(value = "userManagement", method = RequestMethod.POST)
    public ModelAndView processMethodPost(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        String deletedUserId = request.getParameter("deletedUserId");
        if ((deletedUserId != null) && (!deletedUserId.equals(""))) {
            Long id = Long.parseLong(deletedUserId);
            adminService.deleteUserById(id);
        }
        List<User> users = getUserList();
        model.addObject("users", users);
        model.setViewName("adminPages/userManagement");

        return model;
    }

    private List<User> getUserList() {
        return adminService.getAllUsers();
    }

}
