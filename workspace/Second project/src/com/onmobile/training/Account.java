package com.onmobile.training;

public class Account {
	int accountNumber;
	String customerName;
	String accountType;
	double balance;
	Account(int accountNumber, String customerName, String accountType, double balance)
	{
		this.accountNumber = accountNumber;
		this.customerName = customerName;
		this.accountType = accountType;
		this.balance = balance;
	}
	@Override
	public String toString()
	{
		return (accountNumber + "  " + customerName + "  " + accountType + "  " + balance);
	}
}
