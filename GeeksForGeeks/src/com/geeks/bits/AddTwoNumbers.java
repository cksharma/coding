package com.geeks.bits;

public class AddTwoNumbers
{
	public static int recursiveAdd(int x, int y)
	{
		if(y == 0) return x;
		else return recursiveAdd(x ^ y, (x & y) << 1);
	}
	
	public static int nonrecursiveAdd(int x, int y)
	{
		while(y != 0)
		{
			int carry = x & y;
			x = x ^ y;
			y = carry << 1;
		}
		return x;
	}
	
	public static void main(String[] args)
	{
		System.out.println(recursiveAdd(10, 20));
		System.out.println(nonrecursiveAdd(20, 12));
	}
}
