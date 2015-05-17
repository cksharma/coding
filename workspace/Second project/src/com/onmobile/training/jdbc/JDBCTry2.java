package com.onmobile.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class JDBCTry2 
{
	public static void main(String[] args) 
	{
		Scanner ss = new Scanner(System.in);
		System.out.println("Enter the name of table");
		String str = ss.nextLine().trim();
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first", "root", "root"); 
			Statement st = con.createStatement(); 
			ResultSet rs = st.executeQuery("select * from " + str);
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			while(rs.next())
			{
				for(int i = 1; i <= count; i++)
				{
					System.out.print(rs.getString(i) + "\t");
				}
				System.out.println();
			}	
		}	
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
