package edu.cksharma.designpatterns.serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EmployeeAddressSerializationTest {
	public static void main(String[] args) {
		try {
			FileOutputStream fout = new FileOutputStream("emp.dat");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			Employee emp = new Employee(1, "Arjun");
			Address add = new Address("JP Nagar", "Bangalore");
			emp.setAddress(add);
			out.writeObject(emp);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
