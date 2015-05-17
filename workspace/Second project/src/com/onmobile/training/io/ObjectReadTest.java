package com.onmobile.training.io;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectReadTest 
{
	public static void main(String[] args) 
	{
		ObjectInputStream oin = null;
		try
		{
			FileInputStream fin = new FileInputStream("employee.dat");
			oin = new ObjectInputStream(fin);
			for(;;)
			{
				Employee e = (Employee)oin.readObject();
				//System.out.println("Employee  " + i);
				//System.out.println("Employee Id " + e.getEmployeeId());
				//System.out.println("Employee Name " + e.getEmployeeName());
				//System.out.println("Employee designaiton " + e.getDesignation());
				//System.out.println("Employee salary " + e.getSalary());
				
				System.out.println(e);
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(EOFException e3)
		{
			if(oin != null)
			{
				try
				{
					oin.close();
				}
				catch(IOException e8)
				{
					e8.printStackTrace();
				}
			}
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		catch(ClassNotFoundException e2)
		{
			e2.printStackTrace();
		}
		
	}
}
