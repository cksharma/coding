package com.geeks.arrays;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class SubArrayWithGivenSum {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskSubArray solver = new TaskSubArray();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskSubArray {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) 
			arr[i] = in.nextInt();
		int sum = in.nextInt();
		int[] indexArr = calculateIndex(arr, sum);
		for (int i = 0; i < indexArr.length; i++) {
			out.println(indexArr[i]);    
		}
	}
	private int[] calculateIndex(int[] arr, int sum) {
		int[] ans = new int[2];
		int runningSum = arr[0];
		int start = 0;
		for (int i = 1; i < arr.length; i++) {
			while (runningSum > sum && start < i) {
				runningSum = runningSum - arr[start++];
			}
			if (runningSum == sum) {
				ans[0] = start;
				ans[1] = i;
			}
			if (i < arr.length) 
				runningSum = runningSum + arr[i];
		}
		return ans;
	}
}
