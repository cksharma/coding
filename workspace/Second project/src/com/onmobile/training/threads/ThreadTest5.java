package com.onmobile.training.threads;

class P extends Thread {
	@Override
	public void run() {
		synchronized (this) {
			System.out.println("On");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(" Mobile");
			System.out.println();
		}
	}
}

public class ThreadTest5 {

	public static void main(String[] args) {
		P p1 = new P();
		P p2 = new P();
		p1.start();
		p2.start();
	}
}