package com.onmobile.training.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class JDBCTest6
{
	public static void main(String[] args)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root", "root");
			CallableStatement cst = con.prepareCall("{call retrive_NameandSalary(?,?,?)}");
			//cst.registerOutParameter(1, Types.VARCHAR); // here i am saying that the corresponding return type from sql is of double type...
			cst.setInt(1, 1); 
			// i have to set the value for the second and third also.
			cst.execute();
			
			System.out.println("name : " + cst.getString(2));
			System.out.println("bal : " + cst.getString(3));
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