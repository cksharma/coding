package com.onmobile.training.jdbc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;

public class JDBCTry3 
{
	public static void main(String[] args) 
	{
		try {
			FileOutputStream fout = new FileOutputStream("rejected_records.txt");
			PrintWriter pwr = new PrintWriter(fout, true);
			FileReader freader = new FileReader("database.txt");
			BufferedReader br = new BufferedReader(freader);
			String str = "";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first", "root", "root");
			PreparedStatement pst = con.prepareStatement("insert into customer values(?, ?, ?)");
			
			
			while((str = br.readLine()) != null)
			{
				StringTokenizer stk = new StringTokenizer(str, "|");
				int id = Integer.parseInt(stk.nextToken());
				String name = stk.nextToken();
				double balance = Double.parseDouble(stk.nextToken());
				System.out.println(id + "  " + name + " " + balance);
				 
				boolean flag = true;
				Statement st = con.createStatement(); 
				ResultSet rs = st.executeQuery("select * from customer");
				while(rs.next())
				{
					int id_table = rs.getInt(1);
					System.out.print(id_table);
					if(id_table == id)
					{
						flag = false;
						pwr.println(str);
					}
				}
				if(flag)
				{
					
					pst.setInt(1, id);
					pst.setString(2, name);
					pst.setDouble(3, balance);
					pst.addBatch();
				}
			}
			pst.executeBatch();
			System.out.println("Successfully executed");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
