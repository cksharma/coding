package com.onmobile.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RetriveCookieServlet
 */
public class RetriveCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie[] cookies = request.getCookies(); //now server is retriving the cookie from the client..
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		for(Cookie cookie : cookies)
		{
			out.println("<br>" + cookie.getName() + " ==== " + cookie.getValue());
		}
		out.println("</body></html>");
		out.close();
	}
}