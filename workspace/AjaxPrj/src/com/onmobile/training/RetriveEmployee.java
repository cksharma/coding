package com.onmobile.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
 * Servlet implementation class RetriveEmployee
 */
public class RetriveEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DataSource dataSource;
	
	@Override
	public void init()
	{
		
		try
		{
			System.out.println("------here--------------");
			//super.init(config);
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
		}
		catch(NamingException e)
		{
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			Connection con = dataSource.getConnection();
			String sql = "select * from employee where id = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, Integer.parseInt(request.getParameter("ID")));
			ResultSet rs = pst.executeQuery();
			String ans = "";
			if(rs.next())
			{
				ans += rs.getInt(1) + "\n";
				ans += rs.getString(2) + "\n";
				ans += rs.getString(3) + "\n";
				ans += rs.getDouble(4) + "\n";
			}
			else
				
			response.setContentType("text/html");
			response.setHeader("Cache-control", "no-cache");
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println(ans);
			out.println("</body></html>");
			
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
