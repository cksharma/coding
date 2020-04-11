package com.onmobile.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletConfig config = getServletConfig();
		ServletContext context = getServletContext();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>Welcome to JAVA EE Perspective</h1>");
		out.println("<br>" + new Date());
		out.println("</body></html>");
		out.close();
	}
	
}
