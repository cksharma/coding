package com.onmobile.training;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCookieServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String customerId = request.getParameter("cid");
		String customerName = request.getParameter("cname");
		Cookie cookie1 = new Cookie("CustomerId", customerId); // name of cookie, value of cookie..
		Cookie cookie2 = new Cookie("CustomerName", customerName);
		response.addCookie(cookie1); // server is writing the cookie in the client side..
		response.addCookie(cookie2);  // setAttribute, set Parameter, getAttribute, getParameter, getCookies are all request ..
		// adding cookies is response ..
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>Cookies Added </body></html>");
		out.close();
	}
}