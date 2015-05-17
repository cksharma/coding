package com.onmobile.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class RandomNumberGeneratorThread implements Callable<Double> {

	@Override	
	public Double call() throws Exception {
		System.out.println(Thread.currentThread().getName()
				+ ": Finally got started!");
		double sum = 0;
		for (int i = 0; i < 1000000; i++) {
			sum += Math.random();
		}
		//throw new Exception();		
		return sum;
	}
}

public class ExecutorsExample {

	private static final int THREADPOOL_SIZE = 50;

	public static void main(String[] args) {
		ExecutorService threadPool = Executors
				.newFixedThreadPool(THREADPOOL_SIZE);
		List<Future<Double>> futures = new ArrayList<Future<Double>>();
		RandomNumberGeneratorThread thread = new RandomNumberGeneratorThread();
		// Half the threads will be waiting to be scheduled
		for (int i = 0; i < THREADPOOL_SIZE * 2; i++) {
			futures.add(threadPool.submit(thread));
		}

		double finalSum = 0;
		for (Future<Double> future : futures) {
			try {
				finalSum += future.get();
				System.out.println(Thread.currentThread().getName()
						+ ": Got a future");
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
