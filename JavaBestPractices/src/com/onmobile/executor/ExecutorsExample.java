package com.onmobile.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class RandomNumberGeneratorThread implements Callable<Double> {

    @Override
    public Double call() throws Exception {
        System.out.println(Thread.currentThread().getName()
                + ": Finally got started!");
        double sum = 0;
        for (int i = 0; i <= 10; i++) {
            sum += i;
        }
        return sum;
    }
}

public class ExecutorsExample {

    private static final int THREADPOOL_SIZE = 10;

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(THREADPOOL_SIZE);
        List<Future<Double>> futures = new ArrayList<>();
        RandomNumberGeneratorThread task = new RandomNumberGeneratorThread();

        for (int i = 0; i < THREADPOOL_SIZE; i++) {
            futures.add(threadPool.submit(task));
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
