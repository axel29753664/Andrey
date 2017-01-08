package lv.javaguru.java2.servlet;

import javax.servlet.http.HttpServletRequest;

public interface MVCController {

    MVCModel processGet(HttpServletRequest req);

    MVCModel processPost(HttpServletRequest req);

}
