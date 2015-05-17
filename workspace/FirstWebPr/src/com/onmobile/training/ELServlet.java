package com.onmobile.training;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ELServlet
 */
public class ELServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Customer customer = new Customer(101, "Rajesh", 50000);
		customer.setAddress(new Address("Jaya Nagar", "Bangalore"));
		request.setAttribute("company","On Mobile");
		request.setAttribute("customer", customer);
		Map <String, Customer> map = new HashMap <String, Customer> ();
		map.put("A", customer);
		map.put("B", new Customer(101, "Arjun", 600000));
		request.setAttribute("customerList", map);
		
		HttpSession ses = request.getSession();
		ses.setAttribute("customer", new Customer(103, "Rahul", 6000));
		
		RequestDispatcher disp = request.getRequestDispatcher("/ELTest.jsp");
		disp.forward(request, response);
	}
}
