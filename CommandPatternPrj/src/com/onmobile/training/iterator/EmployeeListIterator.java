package com.onmobile.training.iterator;

import java.util.Iterator;

public class EmployeeListIterator implements Iterator {

	private Employee[] list;
	
	private int index;
	
	public EmployeeListIterator(Employee[] employeeList) {
		super();
		this.list = employeeList;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(index < list.length) return true;
		else return false;
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		return list[index++];
		//return null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("remove not supported");
	}	
}
