package lv.javaguru.java2.servlet.mvc;

import javafx.application.Application;
import lv.javaguru.java2.config.SpringConfig;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Craze on 11/24/2016.
 */
public class MVCFilter implements Filter {

    private Map<String, MVCController> controllers;

    private ApplicationContext springContext;

    private MVCController getBean(Class<?> clazz){
        return (MVCController) springContext.getBean(clazz);
    }

    @Override
    public void init (FilterConfig filterConfig) throws ServletException{
        try {
            springContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        } catch (BeansException e) {
        }
        controllers = new HashMap<>();
        controllers.put("/hello", getBean(HelloWorldController.class));
        controllers.put("/events", getBean(EventPageController.class));
    }

    @Override
    public void doFilter (ServletRequest servletRequest,
                          ServletResponse servletResponse,
                          FilterChain filterChain) throws IOException, ServletException{
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String contextURI = req.getServletPath();
        String method = req.getMethod();

        if (contextURI.contains("/css")){
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            MVCController controller = controllers.get(contextURI);
            MVCModel model;

            if (method.equalsIgnoreCase("GET")){
        model = controller.processGet(req);
    } else {
        model = controller.processPost(req);
    }

            req.setAttribute("data", model.getData());
    ServletContext context = req.getServletContext();
    RequestDispatcher requestDispatcher = context.getRequestDispatcher(model.getJspName());
            requestDispatcher.forward(req, resp);
}
    }

    @Override
    public void destroy (){

    }
}
