package com.onmobile.training.threads;

class XXX implements Runnable
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (this) {
			System.out.println("Going to invoke wait " + Thread.currentThread().getName());
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			System.out.println("After being unblocked " + Thread.currentThread().getName());
			
		}
		
	}
}

public class ThreadTest12 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XXX x1 = new XXX();
		Thread t1 = new Thread(x1);
		Thread t2 = new Thread(x1);
		t1.start();
		t2.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (x1) {
			x1.notifyAll(); // we can do x1.notify() twice also.. but if we are not sure how many threads are waiting , we use notifyAll.. this unblocks all the threads acting on that object...
		}
	}
}
