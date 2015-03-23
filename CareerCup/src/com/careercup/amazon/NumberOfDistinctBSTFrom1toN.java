package com.careercup.amazon;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class NumberOfDistinctBSTFrom1toN {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskCatalan solver = new TaskCatalan();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskCatalan {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int n = in.nextInt();
		if (n == 1 || n == 2) {
			System.out.println(n);
			return;
		}
		int[] arr = new int[n + 1];
		
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 2;
		
		for (int i = 3; i <= n; i++) {
			int sum = 0;
			for (int j = 1; j <= i; j++) {
				int leftMe = j - 1;
				int rightMe = i - j;
				sum += arr[leftMe] * arr[rightMe];
			}
			arr[i] = sum;
		}
		System.out.println(arr[n]);
	}
}