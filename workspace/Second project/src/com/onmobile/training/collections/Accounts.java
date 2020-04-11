
package com.onmobile.training.collections;

import java.util.Scanner;
import java.util.TreeSet;
import java.util.Set;

import com.onmobile.training.Employee;

class Customer implements Comparable <Customer>
{
	int customerId;
	String customerName; 
	double balance;
	public Customer(int customerId, String customerName, double balance) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.balance = balance;
	}
	@Override
	public int compareTo(Customer o)
	{
 		int comp = 0;
		if(balance > o.balance)
		{
			comp = -1;			
		}
		else if(balance < o.balance)
		{
			comp = 1;
		}
		return comp;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName="
				+ customerName + ", balance=" + balance + "]";
	}
}

public class Accounts 
{
	public static void main(String[] args) 
	{
		Set <Customer> s = new TreeSet <Customer> ();
		System.out.println("Enter the total number of customers");
		Scanner si = new Scanner(System.in);
		Scanner ss = new Scanner(System.in);
		
		int N = si.nextInt();
		for(int i = 0; i < N; i++)
		{
			System.out.println("Enter the id of customer");
			int ID = si.nextInt();
			System.out.println("Enter the name of customer");
			String name = ss.nextLine();
			System.out.println("Enter the balance");
			double balance = si.nextDouble();
			s.add(new Customer(ID, name, balance));
		}
		for(Customer item : s) System.out.println(item);
	}
}
