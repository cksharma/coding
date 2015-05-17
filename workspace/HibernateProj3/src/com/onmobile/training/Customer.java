package com.onmobile.training;

import java.util.Set;

public class Customer {
	private int customerId;
	private String customerName;
	private Set<Account> accountList;
	
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
	
	public Set<Account> getAccountList() {
		return accountList;
	}
	public void setAccountList(Set<Account> accountList) {
		this.accountList = accountList;
	}
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int customerId, String customerName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
	}
}
