package com.onmobile.training.io;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataWriteTest 
{
	public static void main(String[] args) 
	{
		try 
		{
			FileOutputStream fout = new FileOutputStream("a.dat");
			DataOutputStream dout = new DataOutputStream(fout);
			
			dout.writeInt(23);
			dout.writeDouble(24);
			dout.writeUTF("Hello"); // to write String
			dout.writeLong(45222L);
			dout.close();
			
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
	}
}
