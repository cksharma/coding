package com.jnaapti.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class YAList<T> {

	private static final long serialVersionUID = 1L;
	private List<T> internalList = new ArrayList<T>();
	// Uncomment this line and comment out the next line and try out the code
	private Semaphore lock = new Semaphore(1, true);
	//private Semaphore lock = new Semaphore(1);

	public boolean add(T value) {
		String threadName = Thread.currentThread().getName();
		try {

			System.out.println(threadName + ": Trying to acquire lock");
			lock.acquire();
			System.out.println(threadName + ": Lock acquired");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(threadName + ": Adding value " + value);
		boolean returnValue = internalList.add(value);
		System.out.println(threadName + ": Added value " + value);
		lock.release();
		System.out.println(threadName + ": Lock released");
		return returnValue;
	}
}
