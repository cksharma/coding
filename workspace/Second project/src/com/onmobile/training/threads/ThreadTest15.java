package com.onmobile.training.threads;

class XXXX extends Thread {
	XXXX() {
		System.out.println("Counstructor of XXXX");
	}

	public void run() {
		System.out.println("running");
	}
}

public class ThreadTest15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XXXX x1 = new XXXX() {
			public void run() {
				System.out.println("next running");
			}
		};
		x1.start(); // if i start thethread of x1 then run method which is overridden is invoked.
	}
}
