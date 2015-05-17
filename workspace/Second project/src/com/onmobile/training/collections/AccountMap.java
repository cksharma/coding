package com.onmobile.training.collections;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;


public class AccountMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ss = new Scanner(System.in);
		Scanner si = new Scanner(System.in);
		System.out.println("Enter the total number of accounts");
		int N = si.nextInt();
		Map <Integer, Accounts1> hmap = new HashMap <Integer, Accounts1> ();
		
		for(int i = 0; i < N; i++)
		{
			System.out.println("Enter the id of " + i + "th customer");
			int id = si.nextInt();
			if(hmap.containsKey(id))
			{
				System.out.println("Account with this id already exists..");
				i--;
				continue;
			}
			System.out.println("Enter the name of customer");
			String name = ss.nextLine();
			System.out.println("Enter the balance of customer");
			double balance = si.nextDouble();
			hmap.put(id, new Accounts1(id, name, balance));
		}
	}

}
