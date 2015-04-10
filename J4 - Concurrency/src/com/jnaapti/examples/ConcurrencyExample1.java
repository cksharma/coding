package com.jnaapti.examples;

import com.jnaapti.concurrent.ThreadImpl;

public class ConcurrencyExample1 {

	public static void main(String[] args) {
		new ThreadImpl(false).start();
		new ThreadImpl(false).start();
	}
}
