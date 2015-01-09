package com.onmobile.training.serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationTest {
	public static void main(String[] args) {
		Customer c1 = new Customer("Raju", "Male", 1, 5000);
		Customer c2 = new Customer("Arjun", "Male", 2, 15000);
		try {
			FileOutputStream fout = new FileOutputStream("customer.dat");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(c1);
			out.writeObject(c2);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
