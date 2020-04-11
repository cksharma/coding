package com.onmobile.training;

public class Main 
{
	public static void main(String s)
	{
		System.out.println("First");
	}
	
	public static void main(String s, String str, String... args)
	{
		System.out.println("Second");
	}
	
	public static void main(String[] args) 
	{
		System.out.println("Hello");
		System.out.println("Inside the main Method");
		System.out.println();
		System.out.println("The arguments you have passed are");
		System.out.println();
		for(int i = 0; i < args.length; i++)
		{
			System.out.println(args[i]);
		}
	}
}
