package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	
//dont write your own constructor
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String company = config.getInitParameter("company");
		System.out.println("Init... " + company);
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		System.out.println("Service...");
		PrintWriter out = response.getWriter();
		out.print("Hello " + name + "!");
	}
	@Override
		public void destroy() {
			System.out.println("Destroy...");
		}
}
