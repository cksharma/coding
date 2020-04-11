package com.onmobile.training.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterTest1 
{
	public static void main(String[] args) 
	{
		try 
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the file name");
			String fileName = sc.nextLine();
			File file = new File(fileName);
			if(!file.exists())
			{
				FileOutputStream fout = new FileOutputStream(fileName);
				System.out.println("Enter the contents");
				int c = System.in.read();
				while(c != -1)
				{
					fout.write(c);
					c= System.in.read();
				}
				fout.close();
			}	
			else
			{
				System.out.println("File already exits");
			}
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
	}
}
