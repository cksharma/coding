package com.onmobile.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThirdServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServletContext context = getServletContext();
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("Language : " + context.getInitParameter("language"));
		out.println("<br>Book : " + context.getInitParameter("book"));
		out.println("</html></body>");
		out.close();
		
	}
}
