package lv.javaguru.java2.servlet.mvc;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Craze on 12/8/2016.
 */
public class EventPageController implements MVCController {

    @Override
    public MVCModel processGet(HttpServletRequest req){
        return  new MVCModel("/eventsPage.jsp", "MainEventInfo");
    }

    @Override
    public MVCModel processPost(HttpServletRequest req) { return null; }

}
