/*package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.servlet.SpringAppConfig;
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

public class MVCFilter111 implements Filter {

    private Map<String, MVCController> urlToControllerMap;

    private Logger logger = LoggerFactory.getLogger(MVCFilter111.class);

    private ApplicationContext springContext; //new

    private MVCController getBean(Class<?> clazz) {             //new
        return (MVCController) springContext.getBean(clazz);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       try {
           springContext = new AnnotationConfigApplicationContext(SpringAppConfig.class);
       }
       catch (BeansException e) {
           logger.error("Error");
       }

       urlToControllerMap = new HashMap<>();
       urlToControllerMap.put ("/", getBean(lv.javaguru.java2.servlet.mvc.controllers.HelloWorldController.class));
        //controllers = new HashMap<>();
        //controllers.put("/hello", new lv.javaguru.java2.servlet.mvc.controllers.HelloWorldController());
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String contextURI = req.getServletPath();
        String method = req.getMethod();

        if (contextURI.contains("/css")) {
            filterChain.doFilter(request, response);
        } else {
            MVCController controller = urlToControllerMap.get(contextURI);
            MVCModel model;
            if (method.equalsIgnoreCase("GET")){
                model = controller.processGet(req);
            }
            else {
                model = controller.processPost(req);
            }

            req.setAttribute("data", model.getData());

            ServletContext context = req.getServletContext();
            RequestDispatcher requestDispatcher = context.getRequestDispatcher(model.getJspName());
            requestDispatcher.forward(req, resp);
        }

    }

    @Override
    public void destroy() {

    }

}*/