package com.onmobile.training.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class EmployeeAddressDeserializationTest {
	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("emp.dat");
			ObjectInputStream oin = new ObjectInputStream(fin);
			Employee e1 = (Employee)oin.readObject();
			System.out.println(e1.getEmployeeId());
			System.out.println(e1.getEmployeeName());
			System.out.println(e1.getAddress().getLocation());
			System.out.println(e1.getAddress().getCity());
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
