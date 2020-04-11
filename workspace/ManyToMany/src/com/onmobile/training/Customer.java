package com.onmobile.training;

import java.util.Set;

public class Customer {
	
	private int customerId;
	private String customerName;
	private Set <Address> setAddress;
	
	
	public Set<Address> getSetAddress() {
		return setAddress;
	}
	public void setSetAddress(Set<Address> setAddress) {
		this.setAddress = setAddress;
	}
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
	public Customer(int customerId, String customerName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}	
}
