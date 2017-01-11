package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MakeBetFormController {

    @RequestMapping(value = "makeBetForm", method = {RequestMethod.GET})
    public ModelAndView processRequestGet(HttpServletRequest request) {
        return new ModelAndView("makeBetForm");
    }

    @RequestMapping(value = "makeBetForm", method = {RequestMethod.POST})
    public ModelAndView processRequestPost(HttpServletRequest request) {
        return new ModelAndView("error", "data", "Incorrect request");
    }

}
