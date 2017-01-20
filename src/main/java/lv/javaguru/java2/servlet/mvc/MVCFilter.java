package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.config.SpringAppConfig;

import lv.javaguru.java2.servlet.mvc.controllers.*;
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
    private ApplicationContext springContext;


    private MVCController getBean(Class<?> clazz) {
        return (MVCController) springContext.getBean(clazz);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            springContext = new AnnotationConfigApplicationContext(SpringAppConfig.class);
        } catch (BeansException e) {

        }
        controllers = new HashMap<>();
        controllers.put("/", getBean(StartPageController.class));
        controllers.put("/login", getBean(LoginPageController.class));
        controllers.put("/userPage", getBean(UserPageController.class));
        controllers.put("/registration", getBean(RegistrationController.class));
        controllers.put("/adminPage", getBean(AdminPageController.class));
        controllers.put("/createBetForm", getBean(CreateBetFormController.class));
        controllers.put("/betList", getBean(CreateBetFormController.class));
        controllers.put("/betManagement", getBean(BetManagementController.class));
        controllers.put("/betDeleting", getBean(BetDeletingController.class));
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
            MVCController controller = controllers.get(contextURI);
            MVCModel model;
            if (method.equalsIgnoreCase("GET")) {
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
    public void destroy() {
    }
}