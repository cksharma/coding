

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_B
 */
public class Servlet_B extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
		ServletConfig config = getServletConfig();
		Enumeration e = request.getAttributeNames();
			int cnt = 0;
		while(e.hasMoreElements())
		{
			String attName = (String)e.nextElement();
			//out.println("<br>" + attName + " ==== ");
			out.println("<br>");
			if(cnt++ >= 3)
			out.println(request.getAttribute(attName).toString()); // internally the attributes are stored in Hashtable ...
				// so we using the enumnerations...
		}	
		/*Object o1 = request.getAttribute("a");
		Object o2 = request.getAttribute("b");
		Object o3 = request.getAttribute("c");
		out.println(o1.toString());
		out.println(o2.toString());
		out.println(o3.toString());
		*/
		
		out.close();
	}

}
