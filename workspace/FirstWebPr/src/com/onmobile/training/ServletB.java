package com.onmobile.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletB extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		//out.println("Company: " + request.getAttribute("company"));
		Customer cc = (Customer) request.getAttribute("customerList");
		System.out.println("cc = " + cc);
		Object o = request.getAttribute("customerDetails");
		if(o instanceof Customer)
		{
			Customer cust = (Customer)o;
			out.println("<br>Customer Id: " + cust.getCustomerId());
			out.println("<br>Customer Name: " + cust.getCustomerName());
			out.println("<br>Customer Balance: " + cust.getBalance());
			
		}
		out.println("</body></html>");
		out.close();
	}

}
