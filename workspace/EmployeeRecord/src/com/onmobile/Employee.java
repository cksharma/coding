package com.onmobile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Employee 
{
	static Scanner ss;
	static PreparedStatement pst;
	static ResultSet rs;
	
	public static void readEmployeeById()
	{
		System.out.println("Enter the Employee ID");
		try
		{
			int id = Integer.parseInt(ss.nextLine().trim());
			if(id <= 0)
			{
				System.out.println("ID cannot be <= 0");
				return;
			}
			Connection con = DBSingleton.getConnection();
			pst = con.prepareStatement("select * from employee where id = ?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next())
			{
				System.out.println("Employee Details for this ID is ");
				System.out.println("ID = " + rs.getInt(1));
				System.out.println("Name = " + rs.getString(2));
				System.out.println("Age = " + rs.getInt(3));
			}
			else
			{
				System.out.println("Employee with this ID doesn't exist");
			}
		}
		catch(NumberFormatException ex)	
		{
			System.out.println("ID has to be an integer number");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();			
		}
	}
	
	public static void readEmployeeByName()
	{
		System.out.println("Enter the Employee Name to get the Details");
		try
		{
			String name = ss.nextLine().trim().toLowerCase();
			if(name.length() == 0) 
			{
				System.out.println("Name cannot be of zero length");
				return;
			}
			Connection con = DBSingleton.getConnection();
			pst = con.prepareStatement("select * from employee where name = ?");
			pst.setString(1, name);
			rs = pst.executeQuery();
			boolean found = false;
			System.out.println("Employeee Details by Name");
			while(rs.next())
			{
				found = true;
				System.out.println("ID = " + rs.getInt(1));
				System.out.println("Name = " + rs.getString(2));
				System.out.println("Age = " + rs.getInt(3));
				System.out.println();
			}
			if(!found)
			{
				System.out.println("No Employees found with this Name");
			}
		}
		
		catch (SQLException e) 
		{
			e.printStackTrace();			
		} 
	}
	
	public static void readEmployeeByAge()
	{
		System.out.println("Enter the Employee Age to get the Details");
		try
		{
			int age = Integer.parseInt(ss.nextLine().trim());
			
			if(age <= 0)
			{
				System.out.println("Age cannot be negative.. Try again later");
				return;
			}
			Connection con = DBSingleton.getConnection();
			pst = con.prepareStatement("select * from employee where age = ?");
			pst.setInt(1, age);
			rs = pst.executeQuery();
			boolean found = false;
			System.out.println("Employee Details by Age ");
			while(rs.next())
			{
				found = true;
				System.out.println("ID = " + rs.getInt(1));
				System.out.println("Name = " + rs.getString(2));
				System.out.println("Age = " + rs.getInt(3));
				System.out.println();
			}
			if(!found)
			{
				System.out.println("No Employees found with this age");
			}
		}
		
		catch(NumberFormatException e)
		{
			System.out.println("Age has to be Integer Number");
		}
		
		catch (SQLException e) 
		{
			e.printStackTrace();			
		} 
	}
	
	public static void readEmployee()
	{
		System.out.println();
		System.out.println("1. Enter 'i' to read by ID");
		System.out.println("2. Enter 'n' to read by name");
		System.out.println("3. Enter 'a' to read by age");
		System.out.println("4. Enter any other key to exit");
		System.out.println("Enter your choice");
		System.out.println();
		char ch = Character.toLowerCase(ss.nextLine().charAt(0));
		switch(ch)
		{
			case 'i' :
				readEmployeeById();
				break;
			case 'n' :
				readEmployeeByName();
				break;
			case 'a' :
				readEmployeeByAge();
				break;
			default :
				System.out.println("quitting..");
				break;
		}
	}
	
	public static void insertEmployee()
	{
		System.out.println();
		int id = 0; String name = ""; int age = 0;
		
		try
		{
			System.out.println("Enter ID");
			id = Integer.parseInt(ss.nextLine().trim());
			if(id <= 0)
			{
				System.out.println("ID cannot be <= 0..Try again Later");
				return;
			}
			System.out.println("Enter the Name");
			name = ss.nextLine();
			if(name.length() == 0)
			{
				System.out.println("Name cannot be of zero length.. Try again Later");
				return;
			}
			System.out.println("Enter the Age");
			age = Integer.parseInt(ss.nextLine().trim());
			if(age <= 0)
			{
				System.out.println("Age cannot be <= 0.. Try again Later");
				return;
			}
			Connection con = DBSingleton.getConnection();
			pst = con.prepareStatement("insert into employee values(?, ?, ?)");
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setInt(3, age);
			pst.executeUpdate();
			System.out.println("Employee Details Successfully inserted");
		}
		catch(NumberFormatException e)
		{
			System.out.println("ID and Age both have to be Integer .. Try Again ..");
		} 
		catch (SQLException e)
		{
			System.out.println("This ID is already assigned to other Employee");
		}
	}
	
	public static void updateEmployeeName(int id)
	{
		System.out.println();

		try {
			System.out.println("Enter the new Name");
			String name = ss.nextLine().trim();
			if(name.length() == 0)
			{
				System.out.println("Name cannot be of zero length.. Try again ..");
				return;
			}
			Connection con = DBSingleton.getConnection();
			pst = con.prepareStatement("update employee set name = ? where id = ?");
			pst.setString(1, name);
			pst.setInt(2, id);
			pst.executeUpdate();
			System.out.println("Employee Details Successfully Updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void updateEmployeeAge(int id)
	{
		System.out.println();
		try
		{
			System.out.println("Enter the new Age");
			int age = Integer.parseInt(ss.nextLine().trim());
			if(age <= 0) 
			{
				System.out.println("Age cannot be less than Zero");
				return;
			}
			Connection con = DBSingleton.getConnection();
			pst = con.prepareStatement("update employee set age = ? where id = ?");
			pst.setInt(1, age);
			pst.setInt(2, id);
			pst.executeUpdate();
			System.out.println("Employee Details Successfully Updated");
		}
		catch(NumberFormatException e)
		{
			System.out.println("Age has to be an Integer Number > 0");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateEmployeeNameAge(int id)
	{
		System.out.println();
		System.out.println("Enter the New Name");
		String name = ss.nextLine().trim();
		if(name.length() == 0)
		{
			System.out.println("Name cannot have zero length.. Try again ...");
			return;
		}
		
		System.out.println("Enter the New Age");
		try
		{
			int age = Integer.parseInt(ss.nextLine().trim());
			if(age <= 0) 
			{
				System.out.println("Age cannot be nagative.. Try Again ..");
				return;
			}
			Connection con = DBSingleton.getConnection();
			pst = con.prepareStatement("update Employee set name = ? , age = ? where id = ?");
			pst.setString(1, name);
			pst.setInt(2, age);
			pst.setInt(3, id);
			pst.executeUpdate();
			System.out.println("Employee Details successfully updated");
		}
		catch(NumberFormatException e)
		{
			System.out.println("Age has to an Integer Number > 0");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void updateEmployee()
	{
		System.out.println();
		try
		{
			System.out.println("Enter the Employee ID to update");
			int id = Integer.parseInt(ss.nextLine().trim());
			if(id <= 0)
			{
				System.out.println("Employee Id cannot be <= 0");
				return;
			}
			Connection con = DBSingleton.getConnection();
			pst = con.prepareStatement("select 1 from employee where id = ?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next())
			{
				System.out.println();
				System.out.println("Enter 'n' to update name");
				System.out.println("Enter 'a' to update age");
				System.out.println("Enter 'b' to update both");
				System.out.println("Any other key to exit");
				System.out.println("Enter your choice");
				char ch = Character.toLowerCase(ss.nextLine().trim().charAt(0));
				switch(ch)
				{
					case 'n' :
						updateEmployeeName(id);
						break;
					case 'a':
						updateEmployeeAge(id);
						break;
					case 'b':
						updateEmployeeNameAge(id);
						break;
					default :
						System.out.println("quitting..");
						break;
				}
			}
			else
			{
				System.out.println("No Employee exists with this ID");
			}
		}
		catch(NumberFormatException e)
		{
			System.out.println("ID has to be a valid Integer Number");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void deleteEmployee()
	{
		System.out.println();
		System.out.println("Enter the Employee ID");
		try
		{
			int id = Integer.parseInt(ss.nextLine().trim());
			if(id <= 0)
			{
				System.out.println("ID cannot be <= 0..Try Again with other ID");
				return;
			}
			Connection con = DBSingleton.getConnection();
			pst = con.prepareStatement("select * from employee where id = ?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next())
			{
				pst = con.prepareStatement("delete from employee where id = ?");
				pst.setInt(1, id);
				pst.executeUpdate();
				System.out.println("Employee deleted successfully");
			}
			else
			{
				System.out.println("No Employee with this ID.. Try with other ID");
			}
		}
		catch(NumberFormatException e)
		{
			System.out.println("Id has to be Integer Number > 0");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		ss = new Scanner(System.in);
					
		boolean ok = true;
		outer:
		while(ok)
		{
			System.out.println("1. Press 'r' to read employees");
			System.out.println("2. Enter 'i' to insert employee details");
			System.out.println("3. Enter 'u' to update employee details");
			System.out.println("4. Enter 'd' to delete employee record");
			System.out.println("5. Enter any other key to quit");
			System.out.println("Enter your choice");
			char ch = ss.nextLine().charAt(0);
			switch(ch)
			{
				case 'r':
					readEmployee();
					break;
				case 'i':
					insertEmployee();
					break;
				case 'u':
					updateEmployee();
					break;
				case 'd':
					deleteEmployee();
					break;
				default :
					System.out.println("Exitting from Menu...Thank You..");
					break outer;
			}
			System.out.println();
			System.out.println("Go Main Menu again.. 'y' or 'n' ");
			char ch1 = Character.toLowerCase(ss.nextLine().charAt(0));
			if(ch1 == 'n')
			{
				System.out.println("Exitting .... Thank you ..");
				break;
			}
		}
	} 
}