package com.geeks.arrays;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class MedianOfTwoSortedArraysEqualSize {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskMedianOfTwoSortedArraysEqualSize solver = new TaskMedianOfTwoSortedArraysEqualSize();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskMedianOfTwoSortedArraysEqualSize {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int[] arr1 = {1, 2, 3, 4, 5};
		int[] arr2 = {6, 7, 8, 9, 10};
		int n = arr1.length;
		double ans = getMedian(arr1, 0, n - 1, arr2, 0, n - 1, n);
		System.out.println(ans);
	}
	
	private double getMedian(int[] arr1, int s1, int e1, int[] arr2, int s2, int e2, int n) {
		if (n <= 0) return -1;
		if (n == 1) return (arr1[s1] + arr2[s2]) / 2.;
		if (n == 2) return (Math.max(arr1[s1], arr2[s2]) + Math.min(arr1[e1], arr2[e2])) / 2.;
		
		double m1 = median(arr1, s1, e1);
		double m2 = median(arr2, s2, e2);
		
		if (m1 < m2) {
			if (n % 2 == 0) {
				getMedian(arr1, n / 2 - 1, e1, arr2, s2, n / 2 - 1, n / 2 + 1);
			} else {
				getMedian(arr1, n / 2, e1, arr2, s2, n / 2, n / 2);
			}
		}
		if (m1 < m2)
	    {
	        if (n % 2 == 0)
	            return getMedian(arr1, n/2 - 1, e1, arr2, s2, n / 2, n/2 +1);
	        else
	            return getMedian(arr1, n/2, e1, arr2, s2, n / 2, n/2);
	    }
	 
	    /* if m1 > m2 then median must exist in ar1[....m1] and ar2[m2...] */
	    else
	    {
	        if (n % 2 == 0)
	            return getMedian(arr2, s2, n/2 - 1, arr1, n / 2, e1,  n/2 + 1);
	        else
	            return getMedian(arr2, n/2, e2,  arr1, s1, n / 2, n/2);
	    }
	}
	
	private double median(int[] arr, int s, int e) {
		int n = e - s + 1;
		if (n % 2 == 0) {
			return (arr[n / 2 - 1] + arr[n / 2]) / 2.;
		} else {
			return arr[n / 2];
		}		
	}
}
