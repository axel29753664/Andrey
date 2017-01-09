package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.servlet.mvc.MVCModel;

import javax.servlet.http.HttpServletRequest;

public interface MVCController {

    MVCModel processGet(HttpServletRequest req);

    MVCModel processPost(HttpServletRequest req);
}
