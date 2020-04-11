package com.onmobile.training.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class JDBCTest4 
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root", "root");
			CallableStatement cst = con.prepareCall("{?=call get_salary(?)}");
			cst.registerOutParameter(1, Types.DOUBLE); // here i am saying that the corresponding return type from sql is of double type...
			cst.setInt(2, 5);  // means 2nd ? set the value to be 5...
			cst.execute();
			System.out.println("salary :" + cst.getDouble(1));
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