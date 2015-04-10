package com.onmobile.training.iterator;

import java.util.Iterator;

public class EmployeeList {
	private Employee[] employeeList;
	private int index;
	public EmployeeList(int size)
	{
		employeeList = new Employee[size];
	}
	public void addEmployee(Employee e)
	{
		employeeList[index++] = e;
	}
	public Iterator getIterator() {
		return new EmployeeListIterator(employeeList);
	}
}
