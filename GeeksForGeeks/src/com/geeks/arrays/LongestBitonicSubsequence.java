package com.geeks.arrays;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;

public class LongestBitonicSubsequence {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskG solver = new TaskG();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskG {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		int[] lis = new int[n];
		int[] lds = new int[n];
		
		Arrays.fill(lis, 1);
		Arrays.fill(lds, 1);
		
		for (int i = 1; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}
			}
		}
		for (int i = 1; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] < arr[j] && lds[i] < lds[j] + 1) {
					lds[i] = lds[j] + 1;
				}
			}			
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans = Math.max(ans, lis[i] + lds[i] - 1);
		}
		out.println(ans);
	}
}
 