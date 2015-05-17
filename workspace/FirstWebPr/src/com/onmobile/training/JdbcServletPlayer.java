package com.onmobile.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class JdbcServlet
 */
public class JdbcServletPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	private DataSource ds; // of javax.sql...
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		try {
			Context ctx = new InitialContext();
			Object obj = ctx.lookup("java:comp/env/jdbc/TestDB");
			ds = (DataSource)obj;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Connection con = ds.getConnection();
			Statement st = con.createStatement();
			
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
			ResultSet rs = st.executeQuery("select * from Player where player_id = " + id);
			System.out.println("hello");
			PrintWriter out = response.getWriter();
			if(rs.next())
			{
				out.println("<html><body>");
				out.println("<br> Name " + rs.getString(2));
				out.println("<br> Sports " + rs.getString(3));
				out.println("<br> Country " + rs.getString(4));
				out.println("</body></html>");
			}
			out.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
