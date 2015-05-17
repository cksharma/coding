package com.geeks.arrays;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class EqualZerosAndOnesSubarray {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskF solver = new TaskF();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskF {
	
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
			if (arr[i] == 0) arr[i] = -1;
		}
		int[] leftArr = new int[n];
		assert n > 0 : "Array should have at least one element";
		leftArr[0] = arr[0];
		for (int i = 1; i < n; i++) {
			leftArr[i] = leftArr[i - 1] + arr[i];
		}
		int firstAnswer = getLastZeroInArray(leftArr);
		int secondAnswer = getInSecondWay(leftArr);
		int finalAnswer = -1;
		if (firstAnswer == -1 && secondAnswer == -1) {
			if (arr[0] == 1) {
				out.println("Array contains all 1");
			} else {
				out.println("Array contains all 0");
			}
		} else {
			if (firstAnswer != -1) {
				finalAnswer = firstAnswer + 1;
			} 
			if (secondAnswer != -1) {
				finalAnswer = Math.max(finalAnswer, secondAnswer);
			}
		}
		out.println(finalAnswer);
	}
	
	public int getInSecondWay(int[] leftArr) {
		boolean allOne = true, allZero = true;
		for (int i = 0; i < leftArr.length; i++) {
			if (leftArr[i] == 0) {
				allZero = false;
			} else {
				allOne = false;
			}			
		}
		if (allZero || allOne) {
			return -1;
		}
		int max = getMaximum(leftArr);
		int min = getMinimum(leftArr);
		int[] hash = new int[max - min + 1];
		for (int i = 0; i < leftArr.length; i++) {
			int k = leftArr[i];
			hash[k - min] = i;
		}
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < leftArr.length; i++) {
			int k = leftArr[i];
			if (hash[k - min] != i) {
				ans = Math.max(ans, hash[k - min]);
			}
		}
		return ans;
	}
	
	public int getMaximum(int[] leftArr) {
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < leftArr.length; i++) {
			ans = Math.max(ans, leftArr[i]);
		}
		return ans;
	}
	
	public int getMinimum(int[] leftArr) {
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < leftArr.length; i++) {
			ans = Math.min(ans, leftArr[i]);
		}
		return ans;
	}
	
	public int getLastZeroInArray(int[] leftArr) {
		int index = -1;
		for (int i = 0; i < leftArr.length; i++) {
			if (leftArr[i] == 0) {
				index = i;
			}
		}
		return index;
	}
}