package com.geeks.arrays;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class PanCakeSorting {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskPanCakeSorting solver = new TaskPanCakeSorting();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskPanCakeSorting {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int arr[] = {23, 10, 20, 11, 12, 6, 7};
		int n  = arr.length;
			
		for (int index = n; index > 0; index--) {
			int maxIndex = getMaximumIndex(arr, index - 1);
			System.out.println(arr[maxIndex] + " ,  " + maxIndex);
			if (maxIndex != index - 1) {
				reverse(arr, maxIndex);
				reverse(arr, index - 1);
			}	
		}
		System.out.println();
		for (int item : arr) System.out.print(item + " ");
	}
	
	private void reverse(int[] arr, int index) {
		for (int i = 0; i <= index / 2; i++) {
			swap(arr, i , index - i);
		}
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private int getMaximumIndex(int[] arr, int index) {
		int maxValue = arr[0];
		int maxIndex = 0; 
		for (int i = 0; i <= index; i++) {
			if (arr[i] > maxValue) {
				maxValue = arr[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}
}
