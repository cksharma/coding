package com.onmobile.training.io;

import java.io.File;

public class FileTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("E:/programs and files/Notepad++");
		String[] list = f.list();
		for(String s : list)
		{
			File f1 = new File(f, s); // s is inside the parent directory so we need to specify the parent directory f also.
			// if i remove f from here, then it will check in surrent directory.
			if(f1.isDirectory())
			{
				System.out.println(s);
			}
		}
	}
}
