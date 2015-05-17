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

public class JdbcServletPlayerAdd extends HttpServlet {
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
		// TODO Auto-generated method stub
		try {
			Connection con = ds.getConnection();
			PreparedStatement pst = con.prepareStatement("insert into Player values(?, ?, ?, ?)");
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String sports = request.getParameter("sports");
			String country = request.getParameter("country");
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setString(3, sports);
			pst.setString(4, country);
			pst.execute();
			PrintWriter out = response.getWriter();
			out.println("<html><body>Entry added in database</body></html>");
			
			out.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
