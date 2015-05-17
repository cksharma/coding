package com.onmobile.training.threads;

import java.util.List;
import java.util.ArrayList;

class Storage {
	static private int n = 0;

	static List<Integer> lst = new ArrayList<Integer>();

	int increment() {
		n++;
		return n;
	}

	int getNumber() {
		return n;
	}

	void insertValue() {
		lst.add(n);
	}
}

class Counter extends Thread {
	Storage s;

	Counter(Storage s) {
		this.s = s;
	}

	public void run() {
		for(int i = 0; i < 100; i++) {
			synchronized (s) {

				//s.flag = true;
				s.insertValue();
				int b = s.increment();
				System.out.println("Generating in counter   " + b);
				try {
					Thread.sleep(20);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {
					s.wait();
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				s.notify();
			}
		}
		//s.flag = false;
	}
}

class Printer extends Thread {
	Storage s;

	Printer(Storage s) {
		this.s = s;
	}

	public void run() {
		for(int i = 0; i < 100; i++) {
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (s) {
				System.out.println("printing in printer " + s.getNumber());
				s.notify();
				try {
					Thread.sleep(10);
					s.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

class ThreadTest9 {
	public static void main(String[] args) {
		Storage s = new Storage();
		Counter c = new Counter(s);
		Printer p = new Printer(s);
		c.start();
		p.start();
	}
}