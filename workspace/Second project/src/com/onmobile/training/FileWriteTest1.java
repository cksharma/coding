package com.onmobile.training;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriteTest1
{

	public static void main(String[] args)
	{

		FileOutputStream fout = null;
		try
		{
			fout = new FileOutputStream("x.txt");
			fout.write("this is a test".getBytes());
			fout.close();
		} catch (FileNotFoundException e)
		{

			e.printStackTrace();
		} catch (IOException e)
		{

			e.printStackTrace();
		}

	}
}
