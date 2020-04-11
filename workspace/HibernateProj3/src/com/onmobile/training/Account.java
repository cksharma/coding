package com.onmobile.training;

public class Account {
	private int accountNumber;
	private String accountType;
	private double balance;
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}	
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int accountNumber, String accountType, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = balance;
	}
	
}
