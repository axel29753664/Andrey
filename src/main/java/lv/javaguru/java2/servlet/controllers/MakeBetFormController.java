package lv.javaguru.java2.servlet.controllers;

import lv.javaguru.java2.servlet.MVCController;
import lv.javaguru.java2.servlet.MVCModel;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MakeBetFormController implements MVCController {

    @Override
    public MVCModel processGet(HttpServletRequest req) {

        return new MVCModel("/makeBetForm.jsp", null);
    }

    @Override
    public MVCModel processPost(HttpServletRequest req) {
        return new MVCModel("/error.jsp", "Incorrect request");
    }

}
