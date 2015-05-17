package com.onmobile.training.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectWriteTest
{
	public static void main(String[] args) 
	{
		try 
		{
			FileOutputStream fout = new FileOutputStream("employee.dat");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(new Employee(1, "Rajesh", "Developer", 50000));
			out.writeObject(new Employee(2, "Ravi", "Accountant", 30000));
			out.writeObject(new Employee(3, "Arvind", "Developer", 60000));
			out.close();
			
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		System.out.println("Done");
	}
}
