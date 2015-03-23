package com.geeks.zdummy;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Double> list = new LinkedList<>();
        String res = "";
        while (sc.hasNextDouble()) {
            double d = sc.nextDouble();
            list.add(d);
        }
        double ans = calculateStandardDeviation(list);
        DecimalFormat format = new DecimalFormat("#####0.0000");
        res = format.format(ans);
        System.out.println("Hello world");

    }

    public boolean isPrime(int n) {
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return n > 1;
    }

    static double calculateMean(List<Double> list) {
        double sum = 0.0;
        for (double item : list) sum += item;
        return sum / list.size();
    }

    static double calculateStandardDeviation(List<Double> list) {
        if (list.size() < 2) return 0;
        double mean = calculateMean(list);
        double sum = 0;
        for (double item : list) {
            sum += (item - mean) * (item - mean);
        }
        return Math.sqrt(sum / (list.size() - 1));
    }
}
