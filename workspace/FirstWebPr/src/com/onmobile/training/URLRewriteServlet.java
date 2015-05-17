package com.onmobile.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class URLRewriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		HttpSession session = request.getSession();
		session.setAttribute("Username", uname);
		session.setAttribute("Password", pwd);
		PrintWriter out = response.getWriter();
		out.println("<html><body>Session Attributes Created ");
		out.println("Session id:" + session.getId());
		String url = response.encodeURL("RetriveSessionServlet");
		out.println("<br><a href = '" + url + "'>To continue the session click here </a>");
		out.println("</body></html>");
		out.close();
	}
}
