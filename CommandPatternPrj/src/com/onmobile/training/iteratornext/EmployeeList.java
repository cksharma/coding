package com.onmobile.training.iteratornext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeeList {
	private List <Employee> list;
	private int index;
	public EmployeeList(int size)
	{
		list = new ArrayList <Employee> (size);
	}
	public void addEmployee(Employee e)
	{
		list.add(e);
	}
	public Iterator getIterator() {
		return new EmployeeListIterator(list);
	}
}
