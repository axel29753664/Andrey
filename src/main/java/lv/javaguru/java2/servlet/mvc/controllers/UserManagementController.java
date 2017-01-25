package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.Role;
import lv.javaguru.java2.domain.RolesSet;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.services.UserService;
import lv.javaguru.java2.domain.services.dtoConverters.ConverterDTO;
import lv.javaguru.java2.servlet.dto.UserDTO;
import lv.javaguru.java2.servlet.dto.UserRolesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping(value = "admin")
public class UserManagementController {
    @Autowired
    private UserService userService;

    @Autowired
    private ConverterDTO<User, UserDTO> converterDTO;

    @RequestMapping(value = "userManagement", method = RequestMethod.GET)
    public ModelAndView processMethodGet() {
        ModelAndView model = new ModelAndView();
        List<User> users = getUserList();
        Set<Role> roleSet = RolesSet.getROLES();
        List<Role> roleList = new ArrayList<>();
        roleList.addAll(roleSet);
        model.addObject("roleList", roleList);
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
            userService.deleteUserById(id);
        }
        String updatedUserId = request.getParameter("updatedUserId");
        if ((updatedUserId != null) && (!updatedUserId.equals(""))) {
            Long id = Long.parseLong(updatedUserId);
            User user = userService.getById(id);
            UserDTO userDTO = converterDTO.convertToResponse(user);
            model.addObject("user", userDTO);
            model.addObject("userRoles", new UserRolesModel(user.getRoles()));
            model.setViewName("adminPages/updateUser");
            return model;
        }
        List<User> users = getUserList();
        model.addObject("users", users);
        model.setViewName("adminPages/userManagement");

        return model;
    }

    private List<User> getUserList() {
        return userService.getAllUsers();
    }


}
