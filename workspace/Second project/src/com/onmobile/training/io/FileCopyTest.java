package com.onmobile.training.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileCopyTest
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the source file name ");
		String source = sc.next();
		System.out.println("Enter the target file name");
		String target = sc.next();
		try
		{
			File myFile = new File(source);
			if(myFile.exists())
			{
				FileInputStream fin = new FileInputStream(source);
				BufferedInputStream bin = new BufferedInputStream(fin);
				
				FileOutputStream fout = new FileOutputStream(target);
				BufferedOutputStream bout = new BufferedOutputStream(fout);
				int c = bin.read();
				while(c != -1)
				{
					bout.write(c);
					c = fin.read();
				}
				bin.close();
				bout.close();
			}
			else
			{
				System.out.println("The source file is not found");
			}
			;
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
