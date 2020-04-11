package com.onmobile.training.collections;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PropetiesReadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			FileInputStream fin = new FileInputStream("test.properties");
			Properties prop = new Properties();
			prop.load(fin);
			Enumeration e = prop.propertyNames();
			while(e.hasMoreElements())
			{
				String propName = (String)e.nextElement();
				System.out.println(propName + "===============" + prop.getProperty(propName));
			}
			fin.close();
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
