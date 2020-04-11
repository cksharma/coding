package edu.cksharma.designpatterns.composite;

public class Employee {
	
	private double pay;

	public double getPay() {
		return pay;
	}

	public void setPay(double pay) {
		this.pay = pay;
	}

	public Employee(double pay) {
		super();
		this.pay = pay;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getDeptPay() {
		// TODO Auto-generated method stub
		return pay;
	}	
	
}
