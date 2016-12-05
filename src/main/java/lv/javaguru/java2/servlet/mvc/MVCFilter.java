package lv.javaguru.java2.servlet.mvc;

import javax.servlet.*;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.util.HashMap;

import java.util.Map;


public class MVCFilter implements Filter {
    private Map<String, MVCController> controllers;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        controllers = new HashMap<>();
        controllers.put("/", new DefaultPageController());
        controllers.put("/login", new LoginPageController());
        controllers.put("/userPage", new UserPageController());
        controllers.put("/registration", new RegistrationPageController());

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
            if (model.getJspName().contains(".jsp")) {
                RequestDispatcher requestDispatcher = context.getRequestDispatcher(model.getJspName());
                requestDispatcher.forward(req, resp);
            } else {
                resp.sendRedirect(model.getJspName());
            }
        }
    }

    @Override
    public void destroy() {
    }
}
