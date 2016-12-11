package lv.javaguru.java2.servlet.mvc;


import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
@Component
public interface MVCController {

    MVCModel processGet(HttpServletRequest req);

    MVCModel processPost(HttpServletRequest req);
}
