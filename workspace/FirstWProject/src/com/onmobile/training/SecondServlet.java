package com.onmobile.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		out.println("This is post request.");
		/*out.println("Customer Id:"+request.getParameter("cid"));
		out.println("<br> Name: "+request.getParameter("cname"));*/
		Map<String, Object> map=request.getParameterMap();
		Set<String> paramNames=map.keySet();
		for(String paramName:paramNames)
		{
			String[] s=(String [])map.get(paramName);
			out.println("<br>"+paramName+"=="+s[0]);
		}
		out.println("</body></html>");
		out.close();
	}

}
