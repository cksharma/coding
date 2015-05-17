package com.onmobile.training.threads;

class First extends Thread //implements Runnable
{
	@Override
	public void run()
	{
		for(int i = 1; i <= 500; i++)
		{
			System.out.println("Inside first thread " + Thread.currentThread() + "  " +  i);
		}
	}
}

class Second extends Thread //implements Runnable
{
	@Override
	public void run()
	{
		for(int i = 1; i <= 500; i++)
		{
			System.out.println("Inside second thread" + Thread.currentThread() + "  " +  i);
		}
	}
}

public class ThreadTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		First f = new First();
		Second s = new Second();
		//Thread t1 = new Thread(f);
		//Thread t2 = new Thread(s);
		f.setName("first"); s.setName("second"); // assigning the name to the thread.
		f.setPriority(Thread.MAX_PRIORITY);
		s.setPriority(Thread.MIN_PRIORITY);
		f.start();  
		s.start();
		for(int i = 0; i <= 1000; i++) System.out.println("Inside the main" + Thread.currentThread() + "  " + i);
	}
}
