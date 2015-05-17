package com.onmobile.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstAjaxServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setHeader("Cache-control", "no-cache"); // now each time i clik send , date will get updated.. coz the page is not coming from cache..
		// Cache-control removes the cache everytime .. cache stored in browser is removed.  
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1> Welcome to Ajax " + new Date() + "</h1>");
		//System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC"+request.getParameter("acc"));
		out.println("</body></html>");
		
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setHeader("Cache-control", "no-cache");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1> Welcome to Ajax " + request.getParameter("name") + "</h1>");
		out.println("</body></html>");
		out.close();
	}
}