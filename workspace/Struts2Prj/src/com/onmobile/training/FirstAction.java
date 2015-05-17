package com.onmobile.training;

import com.opensymphony.xwork2.ActionSupport;

public class FirstAction extends ActionSupport {
	
	private int customerId;
	private String customerName;
	private int balance;
	
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
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(customerId + " " + customerName + " " + balance);
		if(customerId == 0 || customerName == null || customerName.equals("") || balance == 0)
			return ERROR;
		return SUCCESS;
	}	
}
