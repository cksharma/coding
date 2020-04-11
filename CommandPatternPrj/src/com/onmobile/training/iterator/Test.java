package com.onmobile.training.iterator;

import java.util.Iterator;

public class Test {
	public static void main(String[] args) {
		EmployeeList list = new EmployeeList(3);
		list.addEmployee(new Employee(1, "Rajesh", "SE"));
		list.addEmployee(new Employee(2, "Nimish", "SSE"));
		list.addEmployee(new Employee(3, "Chandra", "SET"));
		
		Iterator it = list.getIterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
