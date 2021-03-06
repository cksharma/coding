package com.onmobile.training;

public class Customer {
	private int customerId;
	private String customerName;
	private double balance;
	private Address address;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Customer(int customerId, String customerName, double balance) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.balance = balance;
	}
	public Customer() {
		super();
	}
	
}
