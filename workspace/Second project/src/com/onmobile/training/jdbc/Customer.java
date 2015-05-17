package com.onmobile.training.jdbc;

import java.io.Serializable;

public class Customer implements Serializable
{
	int id;
	String name;
	double balance;
	
	Customer(int id, String name, double balance)
	{
		this.id = id;
		this.name = name;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getBalance() {
		return balance;
	}
	
}
