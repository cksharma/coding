package com.geeks.arrays;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class MaximumProductSubarray {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskE solver = new TaskE();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskE {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		int maxTill = Integer.MIN_VALUE;
		int maxRunning = 1;
		int minRunning = 1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				maxRunning = 1;
				minRunning = 1;
				continue;
			} else if (arr[i] > 0) {
				maxRunning = maxRunning * arr[i];
				minRunning = Math.min(1, minRunning * arr[i]);
			} else {
				int temp = maxRunning;
				maxRunning = Math.max(1, minRunning * arr[i]);
				minRunning = Math.min(1, temp * arr[i]);
			}
			maxTill = Math.max(maxTill, maxRunning);
		}
		out.println(maxTill);
	}
}

