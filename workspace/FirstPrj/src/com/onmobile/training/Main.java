package com.onmobile.training;

class P
{
	public boolean equals(P p1)
	{
		System.out.println("invoking equals of P");
		return true;
	}
	public boolean equals(Object o)
	{
		System.out.println("invoking equals of Object");
		return true;
	}
}



public class Main {
	public static void main(String[] args) 
	{
		P p1 = new P();
		P p2 = new P();
		System.out.println(p1.equals(p2));
		Object p3 = p2;
		System.out.println(p3.equals(p2));
		System.out.println(p2.equals(p3));
		Thread t = new Thread();
		
	}
}
