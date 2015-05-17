package com.onmobile.training.jdbc;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerJDBC  implements Serializable
{
	public static void main(String[] args) 
	{
		try
		{
			FileOutputStream fout = new FileOutputStream("hello1.txt");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(new Customer(1, "Chandra", 30000));
			out.writeObject(new Customer(2, "Deep", 40000));
			out.writeObject(new Customer(3, "Raju", 60000));
			out.writeObject(new Customer(4, "Manish", 20000));
			
			out.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		ObjectInputStream in = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first", "root", "root");
			
			FileInputStream fin = new FileInputStream("hello1.txt");
			System.out.println("hero2");
			in = new ObjectInputStream(fin);
			while(true)
			{
				String sql = "insert into customer values(? , ?, ?)";
				PreparedStatement pst =  con.prepareStatement(sql);
				Customer c1 = (Customer) in.readObject();
				int id = c1.getId();
				String name = c1.getName();
				double balance = c1.getBalance();
				pst.setInt(1, id);
				pst.setString(2, name);
				pst.setDouble(3, balance);
				pst.executeUpdate();
				
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		catch(EOFException e3)
		{
			if(in != null)
			{
				try
				{
					in.close();
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				catch(IOException e8)
				{
					e8.printStackTrace();
				}
			}
		}
		
		catch (IOException e) {
			
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
