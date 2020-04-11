package com.jnaapti.concurrent;

import com.jnaapti.collections.ListManager;

public class ThreadImpl extends Thread {

	private boolean synch = false;

	public ThreadImpl(boolean synchronizedList) {
		this.synch = synchronizedList;
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			ListManager.getInstance(this.synch).add(i++);
			if (i == 100)
				break;
		}
		System.out.println(ListManager.getInstance(this.synch).size());
	}

}
