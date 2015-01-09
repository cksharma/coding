package com.geeks.arrays;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class MaximumSumRectangle {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskMaximumSumRectangle solver = new TaskMaximumSumRectangle();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskMaximumSumRectangle {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int arr[][] = { { 1,   2, -1, -4, -20 }, 
						{ -8, -3,  4,  2,  1 }, 
						{ 3,   8, 10,  1,  3 }, 
						{ -4, -1, 1,   7, -6 } };
		int n = arr.length;
		int m = arr[0].length;
		
		
		int[][] dp = new int[n][m];
		for (int row = 0; row < n; row++) for (int col = 0; col < m; col++) dp[row][col] = arr[row][col];
		int ans = dp[0][0];
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				if (row == 0 && col == 0) continue;
				if (col == 0) {
					dp[row][col] = Math.max(dp[row][col], dp[row - 1][col] + dp[row][col]);
					ans = Math.max(ans, dp[row][col]);
					continue;
				}
				if (row == 0) {
					dp[row][col] = Math.max(dp[row][col], dp[row][col - 1] + dp[row][col]);
					ans = Math.max(ans, dp[row][col]);
					continue;
				}
				dp[row][col] = Math.max(dp[row][col], Math.max(dp[row - 1][col] + dp[row][col], Math.max(dp[row][col - 1] + dp[row][col], dp[row - 1][col - 1] + dp[row][col])));
				ans = Math.max(ans, dp[row][col]);
			}
		}
		System.out.println(ans);
	}
}
