package com.onmobile.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		HttpSession session = request.getSession();
		session.setAttribute("Username", uname);
		session.setAttribute("Password", pwd);
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>Session Attributes Created </body></html>");
		out.close();
	}
}