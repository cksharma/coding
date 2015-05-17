package com.onmobile.training.threads;

class R extends Thread
{
	private String s = "abc"; // this string without new operator is common to both the threads.
	@Override
	public void run()
	{		
		synchronized(s)
		{
			System.out.print("On");
			try
			{change();
				Thread.sleep(500);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println(" Mobile");
			System.out.println();
			System.out.println(s);
		}
	}
	public void change()
	{
		s="bcd";
	}
}

public class ThreadTest6 {

	public static void main(String[] args) {
		R r1 = new R();
		R r2 = new R();
		r1.start();
		r2.start();
	}

}
