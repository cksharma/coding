package com.onmobile.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static List<String> list = new ArrayList<String>();
	static
	{
		list.add("apple");
		list.add("application");
		list.add("aaaaa");
		list.add("bbbbb");
		list.add("abababa");
		list.add("ball");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain");
		response.setHeader("Cache-control", "no-cache"); // now each time i clik send , date will get updated.. coz the page is not coming from cache..
		// Cache-control removes the cache everytime .. cache stored in browser is removed.  
		PrintWriter out = response.getWriter();
		//out.println("<html><body>");
		//out.println("<h1> Welcome to Ajax " + new Date() + "</h1>");
		//System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC"+request.getParameter("action"));
		String item = request.getParameter("action");
		String ans = "";
		for(String str : list)
		{
			if(item != null && str.startsWith(item))
			{
				ans = ans + str + "\n";
				
			}
		}
		out.println(ans);
		//out.println("</body></html>");
		
		out.close();
	}
}
