package com.onmobile.training.enums;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

enum FileDirectory
{
	F("File"),D("Directory");
	
	private String str;
	private FileDirectory(String str)
	{
		this.str = str;
	}
	private String getType()
	{
		return str;
	}
}

public class EnumTest4 
{
	
	public static void main(String[] args) 
	{
		Scanner ss = new Scanner(System.in);
		System.out.println("Enter the Name of File or Directory");
		String fd = ss.nextLine();
		System.out.println("Enter it's type as F for file and D for directory");
		String sf = ss.nextLine();
		FileDirectory ok = FileDirectory.valueOf(sf);
		solve(ok, fd);
	}
	
	public static void solve(FileDirectory ok, String name)
	{
		Scanner ss = new Scanner(System.in);
		System.out.println("Your " + ok + " name is " + name);
		switch(ok)
		{
			case F :
				try {
					FileOutputStream fout = new FileOutputStream(name);
					System.out.println("Enter the contents in file and Ctrl + Z to exit");
					int c = System.in.read();
					while(c != -1)
					{
						fout.write(c);
						c = System.in.read();
					}
					fout.close();
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			try {
				FileInputStream fin = new FileInputStream(name);
				int c = fin.read();
				while(c != -1)
				{
					System.out.print((char)c);
					c = fin.read();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				break;
			
			case D:
				File f = new File(name);
				f.mkdir();
				break;
		}
	}	
}
