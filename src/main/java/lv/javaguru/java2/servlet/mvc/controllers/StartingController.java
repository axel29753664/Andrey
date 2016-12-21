package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class StartingController implements MVCController {

    @Override
    public MVCModel processGet(HttpServletRequest req) {

        return new MVCModel("/starting.jsp", null);
    }

    @Override
    public MVCModel processPost(HttpServletRequest req) {
        return new MVCModel("/error.jsp", "Incorrect request");
    }

}
