package com.jnaapti.collections;
public class YAListUser implements Runnable {

	@Override
	public void run() {
		int i = 0;
		while (i < 100) {
			YAListManager.getInstance().add(i);
			i++;
		}
	}

}
