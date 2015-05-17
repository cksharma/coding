package com.onmobile.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest1 {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.jdbc.Driver"); // invokes the static block of the class. loads the JDBC driver name.
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first", "root", "root"); // what is the url used to connect to the database;
			
			Statement st = con.createStatement(); // used to execute any sql statements. Statement is an interface
			ResultSet rs = st.executeQuery("select * from customer"); // contains the list of recrods returned through this query
			//Connection, Statement, ResultSet all are predefined interfaces.
			while(rs.next())
			{
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getDouble(3)); // we tryin to retirve the entries
				// column mumber starts from 1 ...
			}
			Scanner si = new Scanner(System.in);
			Scanner ss = new Scanner(System.in);
			System.out.println("Enter the customer id");
			int id = si.nextInt();
			System.out.println("ENter the customer name");
			String name = ss.nextLine();
			System.out.println("ENter the balance");
			double balance = si.nextDouble();
			String sql = "insert into customer values(?, ?, ?)";
			PreparedStatement pst =  con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setDouble(3, balance);
			//String sql = "insert into customer values(" + id + ",\"" + name + "\"," + balance + ")";
			int ok = pst.executeUpdate();
			rs = st.executeQuery("select * from customer");
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getDouble(3));
			}
			/*System.out.println("Enter the customer id to delete");
			id = si.nextInt();
			int rowCount = st.executeUpdate("delete from customer where customer_id = " + id);
			if(rowCount > 0)
			{
				System.out.println("Number of records deleted : " + rowCount);
			}
			else
			{
				System.out.println("No records were deleted");
			}
			*/
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
