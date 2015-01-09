package com.onmobile.training.composite;

public class Manager extends Employee{
	
	private Employee[] subordinates;
	
	
	public Employee[] getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(Employee[] subordinates) {
		this.subordinates = subordinates;
	}

	public Manager(double pay, Employee[] subordinates) {
		super(pay);
		this.subordinates = subordinates;
	}

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(double pay) {
		super(pay);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double getDeptPay() {
		double deptPay = getPay();
		for(Employee e : subordinates) {
			deptPay = deptPay + e.getDeptPay();
			
		}
		return deptPay;
	}
}
