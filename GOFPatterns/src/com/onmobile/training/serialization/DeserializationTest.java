package com.onmobile.training.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationTest {
	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("customer.dat");
			ObjectInputStream  oin = new ObjectInputStream(fin);
			Customer c1 = (Customer)oin.readObject();
			Customer c2 = (Customer)oin.readObject();
			System.out.println(c1);
			System.out.println(c2);
			oin.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
