package com.onmobile.training.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataReadTest {
	public static void main(String[] args) {
		
		try {
			FileInputStream fin = new FileInputStream("a.dat");
			DataInputStream din = new DataInputStream(fin);
			System.out.println(din.readInt());
			System.out.println(din.readDouble());
			System.out.println(din.readUTF());
			System.out.println(din.readLong());
			
			din.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
