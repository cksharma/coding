package com.onmobile.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RetriveContextAttributeServlet
 */
public class RetriveContextAttributeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext ctx = getServletContext();
		Customer c = (Customer)ctx.getAttribute("customer");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<br>Customer Id : " + c.getCustomerId());
		out.println("<br>Customer Name : " + c.getCustomerName());
		out.println("<br>Balance : " + c.getBalance());
		out.println("</body></html>");
		out.close();
		
	}

}
