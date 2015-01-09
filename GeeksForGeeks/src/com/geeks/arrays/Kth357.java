package com.geeks.arrays;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Kth357 {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskKth357 solver = new TaskKth357();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskKth357 {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		for (int k = 1; k <= 10; k++) {
			int ans = calculateKthNumber(k);
			System.out.println(ans);
		}	
	}
	private int calculateKthNumber(int k) {
		int i3 = 0, i5 = 0, i7 = 0;
		int[] dp = new int[k + 1];
		dp[0] = 1;
		int next_3 = 3;
		int next_5 = 5;
		int next_7 = 7;
		for (int i = 1; i <= k; i++) {
			int num = Math.min(next_3, Math.min(next_5, next_7));
			dp[i] = num;
			if (num == next_3) {
				i3 = i3 + 1;
				next_3 = dp[i3] * 3;
			} 
			if (num == next_5) {
				i5 = i5 + 1;
				next_5 = dp[i5] * 5;
			} 
			if (num == next_7) {
				i7 = i7 + 1;
				next_7 = dp[i7] * 7;
			}
		}
		return dp[k];
	}
}