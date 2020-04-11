package edu.buffalo.cse562;

import java.io.File;

public class SqlFileReader {
	public static void main(String[] args) {
		try {
			
			String dataPath = args[1];
			File file = new File(dataPath);
			System.out.println(file.exists());
			
			String name = args[2];
			file = new File(name);
			System.out.println(file.exists());
			//FileReader reader = new FileReader(new File(""));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
