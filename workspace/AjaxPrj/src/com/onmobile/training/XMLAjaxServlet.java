package com.onmobile.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XMLAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml"); // noew the server should interpret it as XML file...
		PrintWriter out = response.getWriter();
		out.println("<EmployeeList>");
		out.println("<Employee>");
		out.println("<EmployeeId>101</EmployeeId>");
		out.println("<EmployeeName>Raju</EmployeeName>");
		out.println("</Employee>");
		out.println("<Employee>");
		out.println("<EmployeeId>102</EmployeeId>");
		out.println("<EmployeeName>Arjun</EmployeeName>");
		out.println("</Employee>");
		out.println("</EmployeeList>");
	}
}
