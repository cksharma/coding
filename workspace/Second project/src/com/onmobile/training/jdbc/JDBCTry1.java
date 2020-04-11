package com.onmobile.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class JDBCTry1 {

	
	public static void main(String[] args) {
		Scanner ss = new Scanner(System.in);
		Scanner si = new Scanner(System.in);
		System.out.println("Enter the table name");
		String table_name = ss.nextLine();
		System.out.println("Enter the column number");
		int column_no = si.nextInt();
		List <String> lst = new ArrayList <String> ();
		String str = "create table " + table_name + "(";
		for(int i = 0; i < column_no; i++)
		{
			System.out.println("Enter the column name");
			String col = ss.nextLine();
			System.out.println("Enter the column type");
			String type = ss.nextLine();
			if(type.startsWith("int")) 
			{	
				str = str + col + " " + type ;
				if(i < column_no - 1) str += ",";
				continue;
			}	
			if(type.contains("decimal"))
			{
				System.out.println("Enter the length of number");
				int n = si.nextInt();
				System.out.println("Enter the digits after decimal");
				int d = si.nextInt();
				str = str + col + " " + type + "(" + n + "," + d + ")";
				if(i < column_no - 1) str += ",";
				continue;
			}
			System.out.println("Enter the size of varchar");
			int size = si.nextInt();
			str = str + col +" "+  type + "(" + size + ")";
			if(i < column_no - 1) str += ",";
		}
		str += ");";
		System.out.println(str);
		try
		{	
			Class.forName("com.mysql.jdbc.Driver"); // invokes the static block of the class. loads the JDBC driver name.
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first", "root", "root");
			// what is the url used to connect to the database;
			Statement st = con.createStatement(); // used to execute any sql statements. Statement is an interface
			st.executeUpdate(str); 
			System.out.println("Table created");
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
 