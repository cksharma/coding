package com.onmobile.training.threads;

class AA implements Runnable
{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized(this)
		{
			System.out.println("Going to invoke wait");
			
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("After being unlocked");
		}
	}
}

public class ThreadTest10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AA a = new AA();
		Thread t1 = new Thread(a);
		t1.start();
		try
		{
			Thread.sleep(100);  // I am giving time to go thread t1 to wait state by making main thread sleep for some time. Else if i dunn do sleep here, and the thread has not gone to wait state and i am doing notify from main thread. this will generate the illegal invokation
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("Going to notify");
		synchronized(a) // a is the same object on which wait was invoked. So we use notify in the same object.
		{
			a.notify();
		}
	}

}
