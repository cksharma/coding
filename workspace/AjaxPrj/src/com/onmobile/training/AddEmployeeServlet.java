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
public class AddEmployeeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private DataSource dataSource;
	
	@Override
	public void init()
	{
		
		try
		{
			System.out.println("------here--------------");
			
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
		}
		catch(NamingException e)
		{
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = null;
		try
		{
			response.setContentType("text/html");
			response.setHeader("Cache-control", "no-cache");
			out = response.getWriter();
			out.println("<html><body>");
			
			Connection con = dataSource.getConnection();
			String sql = "insert into employee1 values(?, ?, ?, ?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, Integer.parseInt(request.getParameter("ID")));
			pst.setString(2, request.getParameter("name"));
			pst.setString(3, request.getParameter("designation"));
			pst.setDouble(4, Double.parseDouble(request.getParameter("salary")));
			
			int n = pst.executeUpdate();
			String ans = "";
			
			
			if(n > 0)
			{
				out.println("Employee Added ");
			
			}
			else
			{
				out.println("Employee Not Added");
			}	
					
			out.println("</body></html>");
			
		} 
		catch (SQLException e) {
			out.println("Employee with this ID already exists");
			e.printStackTrace();
		}
	}

}
