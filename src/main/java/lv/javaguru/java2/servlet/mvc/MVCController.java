package lv.javaguru.java2.servlet.mvc;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Craze on 11/24/2016.
 */
public interface MVCController {

    MVCModel processGet(HttpServletRequest req);

    MVCModel processPost(HttpServletRequest req);
}
