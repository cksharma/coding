package com.onmobile.training;

class CC
{
	CC()
	{
		System.out.println("CC");
	}
}

class DD extends CC
{
	DD(int i, int j)
	{
		System.out.println("DD");
	}
}

public class X implements First
{
	static int k = 10;
	@Override
	public void test() 
	{
		System.out.println("method of First interface");// TODO Auto-generated method stub
	}
	
	public static void main(String[] args) 
	{
		DD d = new DD(2, 3);
		System.out.println(k);
	}
}
