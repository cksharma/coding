package edu.cksharma.designpatterns.serialization;

import java.io.Serializable;

public class Customer extends Person implements Serializable{
	private int customerId;
	private int balance;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public Customer(String gender, String name, int customerId, int balance) {
		super(gender, name);
		this.customerId = customerId;
		this.balance = balance;
	}
	public Customer()
	{
		super();
		System.out.println("constructor of customer");
	}	
	@Override
	public String toString() {
		return super.toString() + "   " + "Customer [customerId=" + customerId + ", balance=" + balance
				+ "]";
	}
}
