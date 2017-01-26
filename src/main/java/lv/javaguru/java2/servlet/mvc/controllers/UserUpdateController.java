package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.services.UserService;
import lv.javaguru.java2.domain.validators.UserValidator;
import lv.javaguru.java2.servlet.dto.UserDTO;
import lv.javaguru.java2.servlet.dto.UserRolesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "admin")
public class UserUpdateController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserValidator validator;

    @RequestMapping(value = "userUpdate", method = RequestMethod.POST)
    public ModelAndView processPost(@ModelAttribute("userRoles") UserRolesModel userRolesModel,
                                    @Valid @ModelAttribute("user") UserDTO userDTO, BindingResult result) {
        ModelAndView model = new ModelAndView();
        if (!result.hasErrors()) {
            validator.validate(userDTO, result);
            if (!result.hasErrors()) {
                userDTO.setRoles(userRolesModel.getUserRoles());
                User user = userService.convertUserDTO(userDTO);
                userService.updateUser(user);
                model.addObject("url", "userManagement");
                model.setViewName("redirect");
                return model;
            }

        }
        model.addObject("user", userDTO);
        model.addObject("userRoles", userRolesModel);
        model.setViewName("adminPages/updateUser");
        return model;
    }
}
