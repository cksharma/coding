package com.jnaapti.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.jnaapti.collections.AdderThread;

public class ConcurrentAdder {

	static final int THREADPOOL_SIZE = 100;

	public static void main(String[] args) {
		ExecutorService threadPool = Executors
				.newFixedThreadPool(THREADPOOL_SIZE);
		List<Future<Integer>> futures = new ArrayList<Future<Integer>>();
		AdderThread a = new AdderThread();
		for (int i = 0; i < THREADPOOL_SIZE; i++) {
			futures.add(threadPool.submit(a));
		}

		long finalSum = 0;
		for (Future<Integer> future : futures) {
			try {
				finalSum += future.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}

		threadPool.shutdown();
		System.out.println("Final sum: " + finalSum);

	}
}
