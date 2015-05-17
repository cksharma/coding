package com.onmobile.training.threads;

class FirstThread extends Thread //implements Runnable
{
	@Override
	public void run() {
		for (int i = 1; i <= 500; i++) {
			System.out.println("Inside first thread " + Thread.currentThread() + "  " +  i);
			Thread.yield(); // or yield(); this class is the subclass of the Thread class, so i can directly invoke the yield() method.
		}
	}
}

class SecondThread extends Thread //implements Runnable can also be done. 
{
	@Override
	public void run() {
		for (int i = 1; i <= 500; i++) {
			System.out.println("Inside second thread" + Thread.currentThread() + "  " +  i);
			Thread.yield(); // or yield(); but in main we cannot write just yield, we have to write Thread.yield() coz main is not subclass of Thread class
		}
	}
}


public class ThreadTest2 {
	public static void main(String[] args) {
		FirstThread f = new FirstThread();
		SecondThread s = new SecondThread();
		f.setName("First");
		s.setName("Second");      
		f.start();
		s.start();
		/*try {
			f.join();
			for (int i = 1; i <= 500; i++) {
				System.out.println("Inside " + Thread.currentThread() + "  "+ i);
			}
			s.join();
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}*/
		
		for(int i = 0; i <= 500; i++)
		{
			System.out.println("Inside the main thread");
			Thread.yield();
		}
		//System.out.println("Done");
	}
}
