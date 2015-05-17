package data.mining;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

public class PropertiesTest
{
	public static void main(String[] args) 
	{
		Properties prop = new Properties();
		prop.put("chandrA", "kant");
		
		try 
		{
			FileOutputStream fout = new FileOutputStream("ck.properties");
			prop.store(fout, "CK storing");
			fout.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		Properties ppp = new Properties();
		try
		{
			FileInputStream fin = new FileInputStream("ck.properties");
			ppp.load(fin);
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		Enumeration e = ppp.propertyNames();
		while(e.hasMoreElements())
		{
			String str = e.nextElement().toString();
			System.out.println(str + "    " + ppp.getProperty(str));
			
		}
		List <Integer> lst = new ArrayList <Integer> ();
		for(int i = 0; i < 10; i++)
		{
			lst.add(i);
		}
		Iterator <Integer> it = lst.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		String date = "2011/July/22";
		StringTokenizer stk = new StringTokenizer(date, "[/]");
		while(stk.hasMoreTokens())
		{
			System.out.println(stk.nextToken());
		}
		
	}
}
