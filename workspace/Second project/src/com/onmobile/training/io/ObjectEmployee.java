package com.onmobile.training.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class ObjectEmployee
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
			ObjectOutputStream out = new ObjectOutputStream(fout);
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
				out.writeObject(new Employee(empId, name, designation, salary));
			}
			out.close();
		
		}
		catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		ObjectInputStream in = null;
		try
		{
			System.out.println("Enter the salary limit");
			double SS = si.nextDouble();
			FileInputStream fin = new FileInputStream("employee.txt");
			in = new ObjectInputStream(fin);
			for(;;)
			{
				Employee e = (Employee)in.readObject();
				if(e.getSalary() >= SS) System.out.println(e);
			}
		
		}	
		catch(FileNotFoundException e3)
		{
			System.out.println("File not found");
			e3.printStackTrace();
		}
		catch(EOFException e)
		{
			if(in != null)
			{
				try {
					in.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		catch(IOException e11)
		{
			System.out.println("Hello guys");
			e11.printStackTrace();
		}
		catch(ClassNotFoundException e2)
		{
			e2.printStackTrace();
		}
	}
}
