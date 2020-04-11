package com.onmobile.training;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CustomerDAO dao;
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = getServletContext();
		ApplicationContext appCtx = WebApplicationContextUtils.getWebApplicationContext(ctx); // for reading the context file ..
		/*CustomerDetails details = (CustomerDetails) appCtx.getBean("customerDetails"); // I have been specifying the scopre = request there.. so not  .. once we need to read only the it is available...
		int id = Integer.parseInt(request.getParameter("customerId"));
		Customer c = details.getCustomerDetails(id);
		request.setAttribute("cust", c);
		RequestDispatcher disp = request.getRequestDispatcher("/view.jsp");
		disp.forward(request, response);
		*/
		dao = (CustomerDAO) appCtx.getBean("dao");
		int id = Integer.parseInt(request.getParameter("customerId"));
		Customer c = dao.getCustomer(id);
		request.setAttribute("cust", c);
		RequestDispatcher disp = request.getRequestDispatcher("/view.jsp");
		disp.forward(request, response);
	}

}
