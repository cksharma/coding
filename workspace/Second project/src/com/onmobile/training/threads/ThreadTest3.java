package com.onmobile.training.threads;

class X implements Runnable
{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		test();
	}
	
	void test()
	{
		synchronized(this)
		{
			System.out.println("Sun");
			try
			{
				Thread.sleep(1500); // thread moves from running to blocked state
				//when a thread is in sleep state also, no other threads can get the lock this 
				//thread is holding. Thread doesnot release the resource when in sleep.
				//IN sleep it goes to Sleeping state.
				
				//wait(1000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println("Micro");
			try
			{
				Thread.sleep(1500);
				
				//wait(1000); By this thread goes to waiting state or blocked state by releasing 
				//it's lock and resources. Thus any other thread can access those locks and state.
				//Observe the difference by uncommenting the wait methods (comment the sleep methods).
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		} // end of synchronized 
		System.out.println("Systems");
	}
}

public class ThreadTest3 {

	public static void main(String[] args) {
		X obj = new X();
		Thread t1 = new Thread(obj);
		Thread t2 = new Thread(obj);
		t1.start();
		t2.start();
	}
}
