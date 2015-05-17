package com.onmobile.executor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
	public static void main(String[] args) {
		Lock l = new ReentrantLock();
		l.lock();
		l.lock();
		System.out.println("Test");
		l.unlock();
		String str = "";
	}
}
