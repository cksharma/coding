package com.onmobile.training.gc;

class A
{
	private int i;
	A(int i)
	{
		this.i = i;
	}
	@Override
	protected void finalize() throws Throwable
	{
		System.out.println("garbage collecting the object with the value " + i);
	}
}

public class GCTest1 {

	public static void main(String[] args) {
		A a1 = new A(5);
		A a2 = new A(10);
		A a3 = a1;
		A a4 = a2;
		A a5 = a3;
		a1 = null;
		a2 = null;
		a4 = new A(20);
		a5 = a3;
		a3 = a4;
		a1 = a2;
		a2 = a4;
		a1 = new A(30);
		a5 = a1;
		System.gc();
		//System.out.println("mkc");
	}

}
