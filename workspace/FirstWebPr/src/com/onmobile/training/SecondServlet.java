package com.onmobile.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		out.println("This is post request.");
					
		Map<String, Object> map=request.getParameterMap();
		
		if(map != null) out.println("Size of Map = " + map.size());
		
		for(String paramName:map.keySet())
		{
			String[] s=(String [])map.get(paramName);
			out.println("<br>" + paramName + "==" + s[0]);
		}
		
		Enumeration e = request.getParameterNames();
		out.println("<br><br>");
	    while (e.hasMoreElements()) {
	      String name = (String) e.nextElement();
	      out.println("<tr>");
	      out.println("<td>" + name + "</td>");
	      out.println("<td>" + request.getParameter(name) + "</td>");
	      out.println("</tr>");
	      out.println("<br>");
	    }
		
		out.println("</body></html>");
		out.close();
	}
}
