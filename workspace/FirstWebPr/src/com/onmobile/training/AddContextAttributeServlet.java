package com.onmobile.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddContextAttributeServlet
 */
public class AddContextAttributeServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		ServletContext ctx = getServletContext();
		ctx.setAttribute("customer", new Customer(101, "Rajesh", 90000));
		PrintWriter out = response.getWriter();
		out.println("<html><body>Context Attribute created </body></html>");
		out.close();
	}	
}
