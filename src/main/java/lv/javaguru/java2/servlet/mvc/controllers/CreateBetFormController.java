package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.Response;
import lv.javaguru.java2.domain.services.factories.FactoryBet;
import lv.javaguru.java2.servlet.dto.BetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CreateBetFormController {

    @Autowired
    private WebApplicationContext context;
    //private FactoryBet factoryBet;

    @RequestMapping(value = "createBetForm", method = {RequestMethod.GET})
    public ModelAndView processRequestGet(HttpServletRequest request) {
        return new ModelAndView("error", "data", "Incorrect request");
    }

    @RequestMapping(value = "createBetForm", method = {RequestMethod.POST})
    public ModelAndView processRequestPost(HttpServletRequest request) {

        String userIdFromRequest = request.getParameter("userID");
        String eventIdFromRequest = request.getParameter("eventID");
        String betSumFromRequest = request.getParameter("betSum");
        String betConditionFromRequest = request.getParameter("betCondition");

        BetDto betDto = new BetDto(userIdFromRequest, eventIdFromRequest, betSumFromRequest, betConditionFromRequest);
        FactoryBet factoryBet = context.getBean(FactoryBet.class);
        Response response = factoryBet.creationProcess(betDto);

        ModelAndView model = preparationModelAndView(response);
        return model;
    }

    private ModelAndView preparationModelAndView(Response response) {
        if (response.getDbError() != null) {
            return new ModelAndView("createBetError", "data", response.getDbError());
        }
        if (response.getErrorsList() != null) {
            return new ModelAndView("createBetError", "data", response.getErrorsList());
        }
        return new ModelAndView("createBetConfirmation", "data", response.getBetDto());
    }

}