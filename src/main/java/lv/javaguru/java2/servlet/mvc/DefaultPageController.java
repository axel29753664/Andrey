package lv.javaguru.java2.servlet.mvc;

import javax.servlet.http.HttpServletRequest;

public class DefaultPageController implements MVCController {
    @Override
    public MVCModel processGet(HttpServletRequest req) {
        String jspName = "/default.jsp";
        return new MVCModel(jspName, req);
    }

    @Override
    public MVCModel processPost(HttpServletRequest req) {
        return null;
    }
}
