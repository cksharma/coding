package com.onmobile.training.threads;

//notify by another thread instead of main thread
class BB {

}

class Thread1 extends Thread {
	private BB b;

	public Thread1(BB b) {
		super();
		this.b = b;
	}

	public void run() {
		System.out.println("Going to invoke the wait");
		synchronized (b) {
			try {
				b.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("After being unblocked");
		}
	}
}

class Thread2 extends Thread {
	private BB b;

	public Thread2(BB b) {
		super();
		this.b = b;
	}

	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Going to invole notify");
		synchronized (b) {
			b.notify();
			System.out.println("after notifying");
			// after notify it should complete the synchronized state. so first after notifying is printed and then only after being
			// unblocked is printed.
		}
	}
}

public class ThreadTest11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BB b = new BB();
		Thread1 t1 = new Thread1(b);
		Thread2 t2 = new Thread2(b);
		t1.start();
		t2.start();
	}

}
