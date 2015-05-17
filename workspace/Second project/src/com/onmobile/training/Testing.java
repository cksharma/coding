package com.onmobile.training;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Properties;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class Testing {
	public static void main(String[] args) {
		
		List <Account> list = new ArrayList <Account> ();
		Set <Integer> set = new HashSet <Integer> ();
		try
		{
			FileInputStream fin = new FileInputStream("test.properties");
			Properties prop = new Properties();
			prop.load(fin);
			Enumeration e = prop.propertyNames();
			
			while(e.hasMoreElements())
			{
				String propName = (String)e.nextElement();
				if(propName.substring(0, 7).equals("Account"))
				{
					String first = propName;
					String second = prop.getProperty(first);
					String id = first.substring(7);
					int ID = Integer.parseInt(id);
					if(set.contains(ID))
					{
						try
						{
							throw new RuntimeException();
						}
						catch(RuntimeException e2)
						{
							System.out.println("This ID is already present in this properties");
							continue;
						}
					}
					String[] res = second.split(",");
					String name = res[0];
					String type = res[1];
					double balance = Double.parseDouble(res[2]);
					list.add(new Account(ID, name, type, balance));
					set.add(ID);
				}
				else 
				{
					try
					{
						throw new RuntimeException();
					}
					catch(RuntimeException e1)
					{
						System.out.println("this is invalid entry");
						continue;
					}
				}
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
		
		for(Account a : list)
		{
			System.out.println(a);
		}
	}
}

