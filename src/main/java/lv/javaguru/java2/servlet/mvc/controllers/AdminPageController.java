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
public class AdminPageController {
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "adminPage", method = {RequestMethod.GET})
    public ModelAndView processRequestGet(HttpServletRequest request) {
        return new ModelAndView("adminPage");
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
