package com.geeks.arrays;

import static java.lang.Math.max;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class MaximumSumSuchThatNoTwoElementsAreConsecutive {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskMaxSum solver = new TaskMaxSum();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskMaxSum {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) 
			arr[i] = in.nextInt();
		for (int i = 2; i < n; i++) {
			if (arr[i] < 0) 
				arr[i] = max(arr[i - 2], max(0, arr[i - 1]));
			else
				arr[i] = max(arr[i] + arr[i - 2], arr[i - 1]);
		}
		int ans = 0;
		for (int i = 0; i < n; i++) 
			ans = max(ans, arr[i]);
		out.println(ans);
	}
}