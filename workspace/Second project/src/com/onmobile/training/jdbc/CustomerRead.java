package com.onmobile.training.jdbc;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerRead 
{
	public static void main(String[] args) 
	{
		try 
		{
			FileOutputStream fout = new FileOutputStream("database.txt");
			PrintWriter pw = new PrintWriter(fout, true);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first", "root", "root");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from customer");
			while(rs.next())
			{
				pw.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getDouble(3));
			}
			pw.close();
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
