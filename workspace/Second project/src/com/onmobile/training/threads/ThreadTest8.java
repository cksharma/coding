package com.onmobile.training.threads;

class XX extends Thread
{
	static void print ()
	{
		Class cls = null;
		
		try
		{
			cls = Class.forName("com.onmobile.training.threads.XX");
		}
		catch(ClassNotFoundException e2)
		{
			e2.printStackTrace();
		}
		synchronized (cls) // this is how we should lock the class from static context
		{
		System.out.print("[");
		try
		{
			Thread.sleep(500);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.print("java");
		try
		{
			Thread.sleep(500);
		}
		catch(InterruptedException e1)
		{
			e1.printStackTrace();
		}
		System.out.println("]");
		System.out.println();
		}                                                   
	}
	public void run()
	{
		print();
	}
}

public class ThreadTest8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XX x1= new XX();
		XX x2 = new XX();
		x1.start();
		x2.start();
	}

}
