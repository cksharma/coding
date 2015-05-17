package com.onmobile.executor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyLock {
	private static MyLock _instance = null;
	Lock lock = null;

	private MyLock() {
		lock = new ReentrantLock();
	}

	public static MyLock getInstance() {
		if (_instance == null) {
			_instance = new MyLock();
		}

		return _instance;
	}

	public Lock getLock() {
		return this.lock;
	}

}

class LockingThread implements Runnable {

	@Override
	public void run() {

		boolean locked = MyLock.getInstance().getLock().tryLock();
		if (!locked) {
			System.out.println(Thread.currentThread().getName()
					+ ": I couldn't lock, so I am exiting");
			return;
		}
		System.out.println(Thread.currentThread().getName() + ": I locked");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		MyLock.getInstance().getLock().unlock();
		System.out.println(Thread.currentThread().getName() + ": I unlocked");

	}

}

class LockAttemptingThread implements Runnable {

	@Override
	public void run() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Lock lockToAcquire = MyLock.getInstance().getLock();

		while (!lockToAcquire.tryLock()) {
			System.out.println(Thread.currentThread().getName()
					+ ": I couldn't lock, sleeping 1s");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println(Thread.currentThread().getName() + ": I locked");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		lockToAcquire.unlock();
		System.out.println(Thread.currentThread().getName() + ": I unlocked");
	}

}

public class LockExample {

	public static void main(String[] args) {

		new Thread(new LockingThread()).start();
		new Thread(new LockAttemptingThread()).start();

	}

}
