package com.onmobile;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.HashMap;

/**
 * Servlet implementation class PageHit
 */
public class PageHit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int counter;
	
	private Map <String, String> userNamePassword;
	private Map <String, String> visitedUsers;
		
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		visitedUsers = new HashMap <String, String> ();
		
		userNamePassword = new HashMap <String, String> ();
		
		userNamePassword.put("a", "a");
		userNamePassword.put("b", "b");
		userNamePassword.put("c", "c");
		userNamePassword.put("d", "d");
		userNamePassword.put("e", "e");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		counter++;
		
		out.println("<html><body>");
		out.println("</body></html>");
		
		if(userNamePassword.get(name) == null || !userNamePassword.get(name).equals(password))
		{
			out.println("Number of page hits = " + counter);
			out.println("Incorrect username or password");
		}
		else
		{
			out.println("total page hit = " + counter);
			if(!visitedUsers.containsKey(name)) visitedUsers.put(name, password);
			out.println("Unique users who visited this page = " + visitedUsers.size());
		}
	}
}
