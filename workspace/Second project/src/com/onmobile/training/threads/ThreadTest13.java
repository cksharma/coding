package com.onmobile.training.threads;

class YYY extends Thread {

	@Override
	public void run() {
		
		for (int i = 0; i <= 5000; i++) {
			System.out.println("inside YYY thread " + i);
		}
	}
}

public class ThreadTest13 {

	public static void main(String[] args) {
		
		YYY y = new YYY();
		y.setDaemon(true);
		y.start();
		for (int i = 1; i <= 100; i++) {
			System.out.println("Inside the main thread " + i);
		}
	}
	
}
