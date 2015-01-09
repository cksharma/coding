package com.geeks.arrays;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class TwoNumbersWithOddOccurrence {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskH solver = new TaskH();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskH {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		assert n > 0 : "Number of elements has to be > 0";
		int xor = arr[0];
		for (int i = 1; i < n; i++) {
			xor = xor ^ arr[i];
		}
		int x = 0, y = 0;
		int setBit = xor & ~(xor - 1);
		for (int i = 0; i < n; i++) {
			if ((setBit & arr[i]) != 0) {
				x = x ^ arr[i];
			} else {
				y = y ^ arr[i];
			}
		}
		out.println(x + " " + y);
	}
}