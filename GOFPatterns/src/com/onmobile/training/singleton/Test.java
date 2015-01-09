package com.onmobile.training.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {
	public static void main(String[] args) {
		Company c1 = Company.getInstance();
		Company c2 = Company.getInstance();
		System.out.println(c1 == c2);
		System.out.println(c1.getName());

		try {
			FileOutputStream fout = new FileOutputStream("comp.dat");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(c1);
			out.close();
			System.out.println("File me written");
			FileInputStream fin = new FileInputStream("comp.dat");
			ObjectInputStream oin = new ObjectInputStream(fin);
			Company c = (Company)oin.readObject();
			System.out.println(c == c1);
			oin.close();
			System.out.println("File se read");
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
