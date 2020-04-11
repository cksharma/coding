package com.onmobile.training.collections;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		prop.put("city", "Bangalore");
		prop.put("state", "karnataka");
		prop.put("country", "India");
		try
		{
			FileOutputStream fout = new FileOutputStream("test.properties");
			prop.store(fout, "Testing properties");
			fout.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
