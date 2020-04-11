package com.onmobile.training;

class R extends Thread
{
	private Runnable runnable;
	public R(Runnable runnable)
	{
		this.runnable = runnable;
	}
	
	public void run()
	{
		System.out.println("R");
	}
}

class RR implements Runnable
{
	public void run()
	{
		System.out.println("RR");
	}
}

public class ThreadTest 
{
	public static void main(String[] args) 
	{
		new R(new RR()).start();
		new Thread(new RR()).start();
	}
}
