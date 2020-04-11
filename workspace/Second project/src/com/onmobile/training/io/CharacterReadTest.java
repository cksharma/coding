package com.onmobile.training.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CharacterReadTest {

	public static void main(String[] args) {
		
		try {
			FileReader fr = new FileReader("src/com/onmobile/training/io/Employee.java");
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			
			while(line != null)
			{
				System.out.println(line);
				line = br.readLine();
			}
			br.close();
		} 
		catch (FileNotFoundException e) {
	
			e.printStackTrace();
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
	}
}
