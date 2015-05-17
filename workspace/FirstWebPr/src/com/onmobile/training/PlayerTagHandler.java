package com.onmobile.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.sql.DataSource;

public class PlayerTagHandler extends SimpleTagSupport{
	private String tableName;

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	private DataSource dataSource;
	
	@Override
	public void doTag() throws JspException, IOException {
		JspContext ctx = getJspContext();
		JspWriter out = ctx.getOut();
		out.println("<pre>");
		out.println("Player Information");
		try
		{
			Context ctx1 = new InitialContext();
			dataSource = (DataSource) ctx1.lookup("java:comp/env/jdbc/TestDB");
			Connection con = dataSource.getConnection();
			PreparedStatement st = con.prepareStatement("select * from " + tableName);
			ResultSet rs = st.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			//out.println("<html><body>");
			out.println("<table border = '2'>");
			out.println("<tr>");
			for(int i = 1; i <= count; i++)
			{
				
				out.println("<td>" + rsmd.getColumnName(i)+ "</td>");
			}
			out.println("</tr>");
			while(rs.next())
			{
				out.println("<tr>");
				for(int i = 1; i <= count; i++)
				{
					out.println("<td>" + rs.getString(i) + "</td>");
				}
				out.println("</tr>");
			}
			out.println("</table>");
			//out.println("</body></html>");
		}
		catch(NamingException e)
		{
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
