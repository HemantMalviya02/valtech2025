package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = "/*")
public class CounterFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		Map<String, Integer> counters = (Map<String, Integer>) application.getAttribute("counters");
		
		String Url = request.getRequestURI();
		if(counters == null) {
			counters = new HashMap<String, Integer>();
			application.setAttribute("counters", counters);
		}
		
		String url = request.getRequestURI();
		if(counters.containsKey(url) ) {
			int count = counters.get(url);
			counters.put(url, ++count);
		}
		else {
			counters.put(url, 1);
		}
		System.out.println(counters);
		chain.doFilter(request, resp);
	}
	
}
