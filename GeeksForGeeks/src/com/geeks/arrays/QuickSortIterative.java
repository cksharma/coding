package com.geeks.arrays;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Stack;

public class QuickSortIterative {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskQuickSort solver = new TaskQuickSort();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskQuickSort {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int[] arr = new int[] { 10, 50, 90, 20, 30, 40, 60, 70, 80 };

		System.out.println("Iterative : ");
		quickSortIterative(arr, 0, arr.length - 1);
		printArray(arr);

		System.out.println("Randomized : ");
		randomizeArray(arr, 0, arr.length - 1);
		printArray(arr);

		System.out.println("Recursive : ");
		quickSortRecursive(arr, 0, arr.length - 1);
		printArray(arr);
	}

	private void quickSortIterative(int[] arr, int start, int end) {
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		stack.push(arr.length - 1);
		while (!stack.isEmpty()) {
			int en = stack.pop();
			int st = stack.pop();
			if (en - st < 1)
				continue;
			int pivotElement = partition(arr, st, en);

			stack.push(st);
			stack.push(pivotElement - 1);

			stack.push(pivotElement + 1);
			stack.push(en);
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private void randomizeArray(int[] arr, int start, int end) {
		int n = arr.length;
		while (start <= end) {
			int randomIndex = (int) (Math.random() * n);
			if (((start + end) & 1) != 0) {
				swap(arr, randomIndex, start);
				start++;
			} else {
				swap(arr, randomIndex, end);
				end--;
			}
		}
	}

	private void printArray(int[] arr) {
		for (int item : arr)
			System.out.print(item + " , ");
		System.out.println();
	}

	private void quickSortRecursive(int[] arr, int start, int end) {
		if (start >= end)
			return;
		int pivotIndex = partition(arr, start, end);
		quickSortRecursive(arr, start, pivotIndex - 1);
		quickSortRecursive(arr, pivotIndex, end);
	}

	int partition(int arr[], int l, int h) {
		int x = arr[h];
		int i = (l - 1);

		for (int j = l; j <= h - 1; j++) {
			if (arr[j] <= x) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, h);
		return (i + 1);
	}
}
