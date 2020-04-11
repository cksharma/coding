package com.geeks.arrays;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;

public class PairWithGivenDifference {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskD solver = new TaskD();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskD {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		int diff = in.nextInt();
		Arrays.sort(arr);
		int i = 0, j = 1;
		while (i < arr.length && j < arr.length) {
			if (arr[j] - arr[i] == diff) {
				out.println(arr[j] + "  " + arr[i]);
				i++; j++;
			} else if (arr[j] - arr[i] > diff) {
				i++;
			} else {
				j++;
			}
		}
	}
}