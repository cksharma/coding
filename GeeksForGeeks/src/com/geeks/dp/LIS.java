package com.geeks.dp;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;

public class LIS {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
	private int[] height;
	
	public int maximumValue(int[] arr) {
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			ans = Math.max(ans, arr[i]);
		}
		return ans;
	}
	
	public int getIndexOfMaximum(int[] arr) {
		int maxHeight = maximumValue(arr);
		int index = -1;
		for (int i = 0; i < arr.length; i++) {
			if (maxHeight == arr[i]) {
				index = i;				
			}
		}
		return index;
	}
	
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		
		int n = in.nextInt();
		height = new int[n];
		for (int i = 0; i < n; i++) {
			height[i] = in.nextInt();
		}
		int[] length = new int[n];
		int[] parent = new int[n];
	
		Arrays.fill(length, 1);
		Arrays.fill(parent, -1);
		
		for (int i = 1; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if(height[j] < height[i] && length[i] <= length[j]) {
					length[i] = length[j] + 1;
					parent[i] = j;
				}
			}
		}
		int k = maximumValue(length);
		int index = getIndexOfMaximum(length);
		System.out.println("LIS Count " + k);
		System.out.println();
		int[] lisAnswer = new int[k];
		while(index != -1) {
			lisAnswer[--k] = height[index];
			index = parent[index];
		}
		for (int i = 0; i < lisAnswer.length; i++) {
			System.out.print(lisAnswer[i] + "  ");
		}
	}
}