package com.onmobile.training;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerController
 */
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO dao;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		dao = new CustomerDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int customerId = Integer.parseInt(request.getParameter("cid"));
		Customer c = dao.findCustomer(customerId);
		RequestDispatcher dispatcher;
		if(c == null)
		{
			dispatcher = request.getRequestDispatcher("/notFound.jsp");
			
		}
		else
		{
			request.setAttribute("customer", c);
			dispatcher = request.getRequestDispatcher("Found.jsp");
		}
		dispatcher.forward(request, response);
	}

}
