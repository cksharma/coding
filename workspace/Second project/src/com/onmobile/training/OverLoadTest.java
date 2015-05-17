package com.onmobile.training;

class RRR
{
	void print(Integer a)
	{
		System.out.println("Integer method");
	}
	void print(double a)
	{
		System.out.println("double method");
	}
	void print(float a)
	{
		System.out.println("float method");
	}
	void print(long a)
	{
		System.out.println("long method");
	}	
	void print(short a)
	{
		System.out.println("short method");
	}
	void print(Object a)
	{
		System.out.println("Object method");
	}
	
}

public class OverLoadTest {
	public static void main(String[] args) {
		RRR r = new RRR();
		r.print(12); // by default this 12 is int ,,, and it searches for int and lowest type greater than int which can accomodate this.
		// the wrapper class is the highest type, so not preferred.. when only wrapper Integer and Object are there then the wrapper Integer 
		// is given preference in that case.
	}
}
