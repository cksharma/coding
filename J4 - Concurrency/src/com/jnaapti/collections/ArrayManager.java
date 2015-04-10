package com.jnaapti.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class ArrayManager {

	static private ArrayManager _instance = new ArrayManager();
	List<Integer> _internalList = new ArrayList<Integer>();
//	private Semaphore lock = new Semaphore(1, true);
	private Semaphore lock = new Semaphore(1);

	public ArrayManager() {
		for (int i = 1; i <= 100000; i++) {
			_internalList.add(i);
		}
	}

	public static ArrayManager getInstance() {
		if (_instance == null)
			_instance = new ArrayManager();
		return _instance;
	}

	public Integer getNextValue() {
		try {
			lock.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Integer nextValue = null;
		if (_internalList.size() > 0)
			nextValue = _internalList.remove(0);
		lock.release();
		return nextValue;
	}
}
