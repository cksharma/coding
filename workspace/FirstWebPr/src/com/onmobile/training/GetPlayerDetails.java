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
 * Servlet implementation class GetPlayerDetails
 */
public class GetPlayerDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DataSource dataSource;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		try
		{
			Context ctx = new InitialContext();
			dataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/TestDB");
		}
		catch(NamingException e)
		{
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	try
    	{
    		Connection con = dataSource.getConnection();
    		int pid = Integer.parseInt(request.getParameter("pid"));
    		PreparedStatement pst = con.prepareStatement("select * from Player where player_id = ?");
    		pst.setInt(1, pid);
    		ResultSet rs = pst.executeQuery();
    		PrintWriter out = response.getWriter();
    		out.println("<html><body>");
    		if(rs.next())
    		{
    			out.println("<br>Player Id: " + rs.getInt(1));
    			out.println("<br>Player Name: " + rs.getString(2));
    			out.println("<br>Sports Code: " + rs.getString(3));
    			out.println("<br>Country Code: " + rs.getString(4));
    		}
    		else
    		{
    			out.println("No such player");
    		}
    		out.println("</body></html>");
    		out.close();
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
