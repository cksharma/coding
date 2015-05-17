package com.onmobile.training;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeServlet
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Employee e = new Employee(1, "Rajesh", "Developer", 56000);
		request.setAttribute("employee", e); // this attribute name should be the id in the bean of showEmployee...
		RequestDispatcher disp = request.getRequestDispatcher("/showEmployee.jsp");
		disp.forward(request, response);
	}
}
