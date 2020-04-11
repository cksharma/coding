package com.onmobile.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RetriveSessionServlet
 */
public class RetriveSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Enumeration e = session.getAttributeNames();
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("Session ID :" + session.getId());
		while(e.hasMoreElements())
		{
			String attName = (String)e.nextElement();
			out.println("<br>" + attName + " ==== ");
			out.println(session.getAttribute(attName)); // internally the attributes are stored in Hashtable ...
			// so we using the enumnerations...
		}
		
		out.println("</body></html>");
		out.close();
	}

}
