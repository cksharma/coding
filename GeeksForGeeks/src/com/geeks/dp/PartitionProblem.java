package com.geeks.dp;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;

public class PartitionProblem {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskPartition solver = new TaskPartition();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskPartition {
	
	//int[] arr = new int[] {3, 1, 5, 9, 12};
	int[] arr = new int[] {1, 5, 11, 5};
	
	private boolean recurse(int sum, int index, int[] visited) {
		if (sum == 0) return true;
		if (sum != 0 && index == arr.length) return false;
		if (arr[index] > sum) {
			return recurse(sum, index + 1, visited);
		}
		return recurse(sum, index + 1, visited) || recurse(sum - arr[index], index + 1, visited);
	}
	public static int INF = 1 << 25;
	
	private boolean zeroOneKnapsack(int sum) {
		int n = arr.length;
		int[][] dp = new int[n + 1][sum + 1];
		
		for (int i = 1; i <= sum; i++) dp[0][i] = INF;
		for (int i = 0; i <= n; i++) dp[i][0] = 0;
		
		for (int i = 1; i <= n; i++) {
			for (int s = 1; s <= sum; s++) {
				dp[i][s] = dp[i - 1][s];
				if (arr[i - 1] <= s) {
					dp[i][s] = Math.min(dp[i][s], dp[i - 1][s - arr[i - 1]]);
				}
			}
		}
		System.out.println(dp[n][sum]);
		return dp[n][sum] == 0;
	}
	
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int sum = 0;
		for (int item : arr) sum += item;
		if (sum % 2 == 1) {
			System.exit(0);
		}
		int[] visited = new int[arr.length];
		if (recurse(sum / 2, 0, visited))
			System.out.println("Found using Recursion");
		if (zeroOneKnapsack(sum / 2)) {
			System.out.println("Found using DP");
		}
	}
}
