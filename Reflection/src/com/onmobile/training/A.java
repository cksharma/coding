package com.onmobile.training;

public class A {
	private int a;
	private int b;
	static
	{
		System.out.println("static block of A");
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "object of A";
	}
	public A(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	public A() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void print(String name)
	{
		System.out.println("printing " + name);
	}
	
}
