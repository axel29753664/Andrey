package lv.javaguru.java2.servlet;

import lv.javaguru.java2.config.SpringAppConfig;
import lv.javaguru.java2.servlet.controllers.MakeBetController;
import lv.javaguru.java2.servlet.controllers.MakeBetFormController;
import lv.javaguru.java2.servlet.controllers.WelcomeController;
import lv.javaguru.java2.servlet.controllers.StartingController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MVCFilter implements Filter {

    private Map<String, MVCController> controllers;
    private ApplicationContext springContext; //new
    private Logger logger = LoggerFactory.getLogger(MVCFilter.class); // new

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        try {   //new
            springContext = new AnnotationConfigApplicationContext(SpringAppConfig.class);
        } catch (BeansException e) {
            logger.error("Error " + e);
        }

        controllers = new HashMap();
        //controllers.put("/", new WelcomeController());
        //controllers.put("/start", new StartingController());
        //controllers.put("/makeBetForm", new MakeBetFormController());
        //controllers.put("/makeBet", new MakeBetController());
        controllers.put("/", getBean(WelcomeController.class));
        controllers.put("/start", getBean(StartingController.class));
        controllers.put("/makeBetForm", getBean(MakeBetFormController.class));
        controllers.put("/makeBet", getBean(MakeBetController.class));
    }

    private MVCController getBean(Class<?> clazz) {             //new
        return (MVCController) springContext.getBean(clazz);
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String contextURL = req.getServletPath();

        //if (contextURL.contains("/css")) {
        //    filterChain.doFilter(request, response);
        //}
        if (controllers.containsKey(contextURL)) {
            MVCController controller = controllers.get(contextURL);
            MVCModel model = processRequestByMethodAndReturnModel(req, controller);

            req.setAttribute("data", model.getData());

            ServletContext context = req.getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher(model.getJspName());
            requestDispatcher.forward(req, resp);
        } else {
            filterChain.doFilter(request, response);
        }
    }

    private MVCModel processRequestByMethodAndReturnModel(HttpServletRequest req, MVCController controller ) {
        String method = req.getMethod();
        return method.equalsIgnoreCase("GET") ? controller.processGet(req) : controller.processPost(req);
    }

    @Override
    public void destroy() {}

}