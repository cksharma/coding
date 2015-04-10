package com.jnaapti.examples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.jnaapti.collections.YAListUser;

public class ConcurrencyExample3 {

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(100);
		for (int i = 0; i < 100; i++)
			threadPool.execute(new YAListUser());
		threadPool.shutdown();
	}
}