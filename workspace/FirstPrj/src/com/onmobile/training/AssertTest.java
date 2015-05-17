package com.onmobile.training;

public class AssertTest 
{
	public static void main(String[] args) 
	{
		System.out.println("Starting");
		int x = Integer.parseInt(args[0]);
		assert x >= 0 : " Should be positive";
		System.out.println("Printing " + x);
	}
}
