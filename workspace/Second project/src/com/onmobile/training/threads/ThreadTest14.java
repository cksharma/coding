package com.onmobile.training.threads;

class TT extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Going to sleep for 10 seconds");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("Interrupted while sleeping");
		}
		System.out.println("waking up ");
	}
}

public class ThreadTest14 {
	public static void main(String[] args) {
		TT t = new TT();
		t.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Going to interrupt the sleping thread");
		t.interrupt();
	}
}
