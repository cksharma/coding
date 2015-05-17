package com.onmobile.training.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import com.mysql.jdbc.ResultSetMetaData;

public class JDBCTry4 
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/world", "root", "root");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from employee");
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			for(int i = 1; i <= columnCount; i++)
			{
				System.out.println(rsmd.getColumnName(i));
				System.out.println(rsmd.getColumnDisplaySize(i));
				System.out.println(rsmd.getColumnTypeName(i));
			}
			while(rs.next())
			{
				System.out.println(rs.getString(1) + rs.getString(2) + rs.getString(3));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
