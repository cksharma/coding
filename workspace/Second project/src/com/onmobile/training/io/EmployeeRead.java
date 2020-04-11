package com.onmobile.training.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class EmployeeRead 
{
	public static void main(String[] args) 
	{
		Scanner si = new Scanner(System.in);
		Scanner ss = new Scanner(System.in);
		System.out.println("Welcome to Employee records");
		System.out.println("Enter the number of employees");
		int N = si.nextInt();
		try
		{
			FileOutputStream fout = new FileOutputStream("employee.txt");
			DataOutputStream dout = new DataOutputStream(fout);
			dout.writeInt(N);
			for(int i = 0; i < N; i++)
			{
				System.out.println("Enter the employeeId");
				int empId = si.nextInt();
				System.out.println("Enter the employeeName");
				String name = ss.nextLine();
				System.out.println("Enter the employee designation");
				String designation = ss.nextLine();
				System.out.println("Enter the salary");
				double salary = si.nextDouble();
				dout.writeInt(empId);
				dout.writeUTF(name);
				dout.writeUTF(designation);
				dout.writeDouble(salary);
			}
			dout.close();
		
		}
		catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try
		{
			System.out.println("Enter the salary limit");
			double SS = si.nextDouble();
			FileInputStream fin = new FileInputStream("employee.txt");
			DataInputStream din = new DataInputStream(fin);
			N = din.readInt(); 
			for(int i = 0; i < N; i++)
			{
				int id = din.readInt(); // System.out.println("a = " + a);
				String name = din.readUTF(); //System.out.println("name = " + name);
				String desg = din.readUTF(); 
				double salary = din.readDouble(); //System.out.println("salary = " + salary);
				if(salary >= SS)
				{
					System.out.println("ID = " + id);
					System.out.println("Name = " + name);
					System.out.println("Designation = " + desg);
					System.out.println("salary = " + salary);
				}
			}
			din.close();
			
		}	
		catch(FileNotFoundException e3)
		{
			System.out.println("File not found");
			e3.printStackTrace();
		}
		catch(IOException e11)
		{
			System.out.println("Hello guys");
			e11.printStackTrace();
		}
	}
}
