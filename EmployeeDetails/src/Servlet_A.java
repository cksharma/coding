

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet_A extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Map <String, Customer> hmap = new HashMap <String, Customer> ();
	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		hmap.put("a", new Customer(101, "Chandra", 50000));
		hmap.put("b", new Customer(101, "Surya", 60000));
		hmap.put("c", new Customer(101, "Rajini", 70000));
	}
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher disp = request.getRequestDispatcher("/Servlet_B");
		for(String str : hmap.keySet()) request.setAttribute(str, hmap.get(str));
		disp.forward(request, response);
	}
}
