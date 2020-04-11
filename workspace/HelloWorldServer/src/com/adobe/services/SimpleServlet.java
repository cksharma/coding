package com.adobe.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.server.test.Employee;

/**
 * Servlet implementation class SimpleServlet
 */
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int id = Integer.valueOf(request.getParameter("id"));
		System.out.println(name + "   " + id);
		PrintWriter writer = response.getWriter();
		writer.print(new Employee(name, id));
	}

}
