package com.geeks.arrays;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class SmallestPositiveNumberMissingUnsortedArray {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskI solver = new TaskI();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskI {	
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		int shift = getShiftIndex(arr);
		for (int i = 0; i + shift < arr.length; i++) {
			arr[i] = arr[i + shift];
		}
		int len = arr.length - shift;
		int ans = getSmallestPositive(arr, len);
		System.out.println(ans);
	}
	public int getSmallestPositive(int[] arr, int len) {
		for (int i = 0; i < len; i++) {
			int k = Math.abs(arr[i]);
			if (k <= len) {
				arr[k - 1] = -arr[k - 1];
				if (arr[k - 1] > 0) arr[k - 1] *= -1;
			}
		}
		int i;
		for (i = 1; i <= len; i++) {
			if (arr[i - 1] > 0) {
				return i;
			}
		}
		return i;
	}
	public int getShiftIndex(int[] arr) {
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= 0) {
				swap(arr, i, j);
				j++;
			}
		}
		return j;
	}
	public void swap(int[] arr, int i, int j) {
		arr[i] = arr[i] + arr[j];
		arr[j] = arr[i] - arr[j];
		arr[i] = arr[i] - arr[j];
	}
}