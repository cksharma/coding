package com.onmobile.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    private Map<String,String> paramList;
	public void init()
	{
		ServletConfig config=getServletConfig();
			Enumeration e=config.getInitParameterNames();
			paramList=new HashMap<String,String>();
		while(e.hasMoreElements())
		{
			String paramName=(String)e.nextElement();
			paramList.put(paramName, config.getInitParameter(paramName));
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		out.println("<h1>Welcome to JAVA EE Perspective</h1>");
		ServletConfig config=getServletConfig();
		//out.println("<br>"+getInitParameter("country"));
		out.println(paramList);
		out.println("<br>"+new Date());
		out.println("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
