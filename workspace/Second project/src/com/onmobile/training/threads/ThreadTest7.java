package com.onmobile.training.threads;

class S extends Thread
{
	private StringBuffer sb  = new StringBuffer(); // since we have used or created new object for each threads. we dunn need to go for synchronization test
	@Override
	public void run()
	{
		
		synchronized(sb)
		{
			System.out.print("On");
			try
			{
				Thread.sleep(500);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println(" Mobile");
			System.out.println();
		}
	}
}

public class ThreadTest7 {

	public static void main(String[] args) {
		S s1 = new S();
		S s2 = new S();
		s1.start();
		s2.start();
	}

}
