package com.onmobile.training.io;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Z_ObjectRead 
{
	public static void main(String[] args) 
	{
		ObjectInputStream oin = null;
		try {
			FileInputStream fin = new FileInputStream("employee.dat");
			oin = new ObjectInputStream(fin);
			for(;;)
			{
				Employee ck = (Employee)oin.readObject();
				System.out.println(ck);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(EOFException e)
		{
			if(oin != null)
			{
				try {
					oin.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
