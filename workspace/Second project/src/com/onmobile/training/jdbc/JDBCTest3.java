package com.onmobile.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTest3 
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first", "root", "root"); 
			PreparedStatement pst = con.prepareStatement("insert into customer values(?, ?, ?)");
			pst.setInt(1, 201);
			pst.setString(2, "Arjun");
			pst.setDouble(3, 6000);
			pst.addBatch();
			pst.setInt(1, 202);
			pst.setString(2, "Ramesh");
			pst.setDouble(3, 7000);
			pst.addBatch();
			int[] rowsUpdated = pst.executeBatch(); // returns the integer array...
			int count = 0;
			for(int i  : rowsUpdated) // each entry in the array ia having the number of rows affected by the updation of the query. 
			{	
				count += i;
			}	
			System.out.println(count);
			System.out.println("Successfully updated");
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
