

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieAddServlet
 */
public class CookieAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		Cookie cook = new Cookie("Name" , username);
		Cookie cook1 = new Cookie("Password", password);
		response.addCookie(cook);
		response.addCookie(cook1);
		PrintWriter out = response.getWriter();
		out.println("Cookies added");
		out.close();
	}
}
