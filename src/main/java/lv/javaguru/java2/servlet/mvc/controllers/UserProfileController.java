package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.Role;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.services.UserService;
import lv.javaguru.java2.domain.services.dtoConverters.ConverterDTO;
import lv.javaguru.java2.servlet.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Set;

@Controller
public class UserProfileController {
    @Autowired
    private UserService userService;
    @Autowired
    private ConverterDTO<User, UserDTO> converterDTO;
    private Set<Role> roles;

    @RequestMapping(value = "userProfile", method = RequestMethod.GET)
    public ModelAndView processGet(Principal principal) {
        ModelAndView model = new ModelAndView();
        User user = userService.getUserByLogin(principal.getName());
        roles = user.getRoles();
        UserDTO userDTO = converterDTO.convertToResponse(user);
        model.addObject("user", userDTO);
        model.setViewName("userProfile");
        return model;
    }

    @RequestMapping(value = "userProfile", method = RequestMethod.POST)
    public ModelAndView processPost(@Valid @ModelAttribute("user") UserDTO userDTO, BindingResult result, ModelAndView model) {

        if (!result.hasErrors()) {
            User user = converterDTO.convertFromRequest(userDTO);
            user.setRoles(roles);
            userService.updateUser(user);
        }
        return model;
    }
}
