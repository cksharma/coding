package com.onmobile.training.collections;

abstract class QQQQ
{
	abstract int getA();
	QQQQ()
	{
		System.out.println("hello");
	}	
}



class PPPP
{
	private int a = 2;
	QQQQ q1 = new QQQQ() {
		
		@Override
		int getA() {
			// TODO Auto-generated method stub
			return a;
		}
	};
	void test()
	{
		final int p = 5;
		System.out.println(q1.getA());
		QQQQ q1 = new QQQQ() {
			
			@Override
			int getA() {
				// TODO Auto-generated method stub
				return p;
			}			
		};
		System.out.println(q1.getA());
	}
}

public class Main
{
	public static void main(String[] args) 
	{
		PPPP p = new PPPP();
		p.test();
		
		
	}
}