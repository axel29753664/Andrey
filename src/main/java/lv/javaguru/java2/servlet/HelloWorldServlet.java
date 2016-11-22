package lv.javaguru.java2.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req,
	                     HttpServletResponse resp) throws ServletException, IOException {


		// Prepare output html
		//PrintWriter out = resp.getWriter();
		//out.println("<h1>" + "Hello WWW world!" + "</h1>");
		//out.println("<h1>" + "Hello WWW world from Java!" + "</h1>");
		req.getRequestDispatcher("helloWorld.jsp").forward(req, resp);
	}

}
