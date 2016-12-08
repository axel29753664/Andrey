package lv.javaguru.java2.servlet.mvc;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Craze on 11/24/2016.
 */

@Component
public class HelloWorldController implements MVCController {

    @Override
    public MVCModel processGet(HttpServletRequest req){

        return new MVCModel("/helloWorld.jsp", "Hello WWW world from Java!");
    }

    @Override
    public MVCModel processPost(HttpServletRequest req){
        return null;
    }


}
