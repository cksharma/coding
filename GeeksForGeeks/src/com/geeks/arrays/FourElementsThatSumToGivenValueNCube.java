package com.geeks.arrays;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;

public class FourElementsThatSumToGivenValueNCube {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskFourSum solver = new TaskFourSum();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskFourSum {
	
	public int[] getMoreTwoElements(int[] arr, int sum, int i, int j) {
		int k = i + 1, l = j + 1;
		int[] ans = new int[2]; 
		Arrays.fill(ans, Integer.MIN_VALUE);
		while (k < l && k < arr.length && l < arr.length) {
			if (k == i || k == j) {
				k++;
				continue;
			}
			if (l == j || l == i) {
				l--;
				continue;
			} 
			if (arr[k] + arr[l] == sum) {
				ans[0] = arr[k];
				ans[1] = arr[l];
				break;
			} else if (arr[k] + arr[l] > sum) {
				l--;
			} else if (arr[k] + arr[l] < sum) {
				k++;
			}			
		}
		return ans;
	}
	
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) arr[i] = in.nextInt();
		int sum = in.nextInt();
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int twoSum = arr[i] + arr[j];
				if (twoSum < sum) {
					int[] ans = getMoreTwoElements(arr, sum - twoSum, i, j);	
					if (ans[0] != Integer.MIN_VALUE || ans[1] != Integer.MIN_VALUE) {
						out.println(arr[i] + " " + arr[j] + " " + ans[0] + " " + ans[1]);
					}
				}
			}
		}
	}
}
