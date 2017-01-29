package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.services.ApplyBetService;
import lv.javaguru.java2.servlet.dto.BetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class CreateBetFormByChoosingConditionController {

    @Autowired
    private ApplyBetService applyBetService;

    @RequestMapping(value = "createBetFormByChoosingCondition", method = {RequestMethod.GET})
    public ModelAndView processRequestGet(HttpServletRequest request) {
        return new ModelAndView("error", "data", "Incorrect request");
    }

    @RequestMapping(value = "createBetFormByChoosingCondition", method = {RequestMethod.POST})
    public ModelAndView processRequestPost(@Valid @ModelAttribute("betDTO") BetDTO betDTO,
                                           BindingResult validResult, ModelAndView model) {

        if (!validResult.hasErrors()) {
            applyBetService.apply(betDTO, validResult);
            if (!validResult.hasErrors()) {
                model.setViewName("createBetConfirmation");
                model.addObject("bet", betDTO);
            }
        }
        return model;
    }

}
