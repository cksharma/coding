package com.onmobile.training.iteratornext;

import java.util.Iterator;
import java.util.List;

public class EmployeeListIterator implements Iterator {

	private List <Employee> list;
	private Iterator <Employee> it;
	private int index;
	
	public EmployeeListIterator(List <Employee> employeeList) {
		super();
		this.list = employeeList;
		it = list.iterator();
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return it.hasNext();
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		return it.next();
		//return null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("remove not supported");
	}	
}
