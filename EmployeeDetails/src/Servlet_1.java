

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 * Servlet implementation class Servlet_1
 */
public class Servlet_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 private Enumeration e;
    private Map<String,String> paramList;
    public void init()
    {
 	   ServletConfig config = getServletConfig();
 		/*out.println("<br>Country: " + config.getInitParameter("country"));*/
 	 e = config.getInitParameterNames();
 	 paramList = new HashMap<String, String>();
 		while(e.hasMoreElements())
 		{
 			String paramName = (String)e.nextElement();
 			paramList.put(paramName,config.getInitParameter(paramName));
 		}
    }
    public void init(ServletConfig config)
    {
 	   try {
			super.init(config);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<br>Hello guys welcome to servlets");
		out.println("</body></html>");
		out.println("<br>");
		for(String str : paramList.keySet())
		{
			out.println(str + "===" + paramList.get(str));
			out.println("<br>");
		}
		out.println("username = " + name);
		out.println("<br>");
		out.println("Password = " + password);
		out.println("<br>");
		String dob = request.getParameter("dob");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
		try {
			Date d = sf.parse(dob);
			Date now = new Date();
			long now_time = now.getTime();
			long dob_time = d.getTime();
			out.println("Your age" + ((now_time - dob_time) / 86400000 ) / 365);
			out.println("<br>");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String gender = request.getParameter("gender");
		if(gender.equals("male")) out.print("Mr. ");
		if(gender.equals("female")) out.print("Mrs. ");
		out.println("<br>");
		String ed = request.getParameter("grad");
		if(ed != null && ed.equals("education")) out.println("You are a graduate");
		else out.println("You are not a graduate");
		out.println("<br>");
		out.close();
	}
}
