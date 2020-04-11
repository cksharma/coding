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
 * Servlet implementation class MovieServlet
 */
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
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
			int cnt = 0;
			try {
				Connection con = ds.getConnection();
				PreparedStatement pst = con.prepareStatement("insert into movie values(?, ?)");
				for(int i = 0; i <= 100; i++)
				{
					pst.setInt(1, cnt++);
					pst.setString(2, "Hiii");
					pst.addBatch();
				}	
				pst.executeBatch();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				
				Connection con = ds.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from Movie");
				PrintWriter out = response.getWriter();
				out.println("<html><body>");
				out.println("<table border = 2>");
				out.println("<tr><th>Movie Id </th><th>Movie Name</th>");
				while(rs.next())
				{
					out.println("<tr>");
					out.println("<td>" + rs.getInt(1));
					out.println("<td>" + rs.getString(2));
				}
				out.println("</table>");
				out.println("</body></html>");
				out.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
