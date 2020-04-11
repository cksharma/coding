package assessment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ExternalizableMain {
	/**
	 * @author Arpit Mandliya
	 */
	public static void main(String[] args) {

		List <Employee> emp = new ArrayList <Employee> ();
		for (int i = 0; i < 1000000; i++) {
			Employee emp1 = new Employee();
			emp1.setEmployeeId(i + 1);
			emp1.setEmployeeName("Arpit" + i);
			emp1.setDepartment("CS" + i);
			emp.add(emp1);
		}
		long startTime = System.currentTimeMillis();
		// Serialize
		try {
			FileOutputStream fileOut = new FileOutputStream("employee.ser");
			ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
			outStream.writeObject(emp);
			outStream.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		
		System.out.println("Time taken " + (endTime - startTime));

		// Deserialize
		emp = null;
		try {
			FileInputStream fileIn = new FileInputStream("employee.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			emp = (List <Employee>) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Employee class not found");
			c.printStackTrace();
			return;
		}
		System.out.println("Deserialized Employee List...");
		System.out.println("Emp list: " + emp.size());

	}
}
