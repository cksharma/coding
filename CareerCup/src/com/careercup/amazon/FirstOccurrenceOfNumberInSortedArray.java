package com.careercup.amazon;

import static java.lang.Math.min;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class FirstOccurrenceOfNumberInSortedArray {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskFirstOccurrence solver = new TaskFirstOccurrence();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskFirstOccurrence {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = in.nextInt();
		int start = 0, end = n - 1;
		int value = in.nextInt(); 
		int ans = Integer.MAX_VALUE;
		while (true) {
			int middle = (start + end) / 2;
			if (start == end && arr[middle] == value) {
				ans = min(ans, middle);
				break;
			}	
			if (arr[middle] > value) {
				end = middle - 1;
			} else if (arr[middle] < value) {
				start = middle + 1;
			} else {
				ans = min(ans, middle);
				end = middle - 1;
			}
		}
		out.println(ans);
	}
}
