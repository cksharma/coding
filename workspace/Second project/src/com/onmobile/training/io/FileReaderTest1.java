package com.onmobile.training.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileReaderTest1 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the file name");
		String file = sc.next();
		try
		{
			File myfile = new File(file);
			if(myfile.exists())
			{
			FileInputStream fin = new FileInputStream(file);
			int c = fin.read();
			while(c != -1)
			{
				System.out.print((char)c);
				c = fin.read();
			}
			fin.close();
			}
			else
			{
				System.out.println("File with this name doesnot exist");
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
	}
}
