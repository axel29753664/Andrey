package lv.javaguru.java2.servlet.mvc;

import javax.servlet.http.HttpServletRequest;

public class MenuPageController implements MVCController {
    @Override
    public MVCModel processGet(HttpServletRequest req) {
        return new MVCModel("/menu.jsp", null);
    }

    @Override
    public MVCModel processPost(HttpServletRequest req) {
        return null;
    }
}
