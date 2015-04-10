package com.jnaapti.examples;

import com.jnaapti.concurrent.ThreadImpl;

public class ConcurrencyExample2 {

	public static void main(String[] args) {
		new ThreadImpl(true).start();
		new ThreadImpl(true).start();
	}
}
