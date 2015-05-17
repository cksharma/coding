package com.onmobile.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest2 {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first", "root", "root"); 
			Statement st = con.createStatement(); 
			ResultSet rs = st.executeQuery("select * from customer where customer_id = 0"); // contains the list of recrods returned through this query
			//evene if we do select * form customer the answer is the same,
			//if i have this condition i.e. where customer_id = 0 then it's not reuturning the single records.. and thus
			// the retrival time is saved ....so it's advisiable to do so ....
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			System.out.println("Total number of columns : " + count);
			for(int i = 1; i <= count; i++)
			{
				System.out.println("Column Name : " + rsmd.getColumnName(i));
				System.out.println("Column type : " + rsmd.getColumnTypeName(i));
				
				System.out.println("Column size : " + rsmd.getColumnDisplaySize(i));
			}
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
