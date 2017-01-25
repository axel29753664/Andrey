package lv.javaguru.java2.servlet.mvc.controllers.controllerServices;

import lv.javaguru.java2.domain.services.EventServices;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface Process {
    void doAction(HttpServletRequest request, int eventListSize, EventServices eventServices);
}
