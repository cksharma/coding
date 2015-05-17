package com.onmobile.training;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletA extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private Map <Integer, Customer> customerList = new HashMap <Integer, Customer> ();
	
	@Override
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
		customerList.put(1, new Customer(1, "Rajesh", 70000));
		customerList.put(2, new Customer(2, "Arvind", 80000));
		customerList.put(3, new Customer(3, "Prakash", 90000));	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		RequestDispatcher disp = request.getRequestDispatcher("/ServletB");
		//request.setAttribute("company", "OnMobile");
		int id = Integer.parseInt(request.getParameter("id"));
		Customer c = customerList.get(id);
		
		request.setAttribute("customerDetails", c);
		disp.forward(request, response);
	}
}
