package com.onmobile.training.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class JDBCTest5
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root", "root");
			CallableStatement cst = con.prepareCall("{?=call get_capital(?)}");
			cst.registerOutParameter(1, Types.VARCHAR); // here i am saying that the corresponding return type from sql is of double type...
			cst.setString(2, "India");  // means 2nd ? set the value to be 5...
			cst.execute();
			System.out.println("capital : " + cst.getString(1));
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}