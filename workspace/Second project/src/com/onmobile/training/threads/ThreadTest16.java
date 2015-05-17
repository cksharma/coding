package com.onmobile.training.threads;

class PP extends Thread {

	public void run() {
		for (int i = 1; i <= 200; i++) {
			System.out.println("inside p thread");
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}

public class ThreadTest16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PP p = new PP();
		p.start();
		System.out.println("Is P Alive ?  " + p.isAlive());
		new PPP(Thread.currentThread()).start();
		try {
			p.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("Main interupted");
		}
		System.out.println("Is P Alive ?  " + p.isAlive());
		for (int i = 1; i <= 200; i++) {
			System.out.println("Inside the main  " + i);
		}
	}
}

class PPP extends Thread {
	Thread t;

	PPP(Thread t) {
		this.t = t;
	}

	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Going to interrupt the main thread");
		t.interrupt();
	}
}