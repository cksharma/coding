package com.geeks.arrays;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class MedianOfTwoSortedArraysUnEqualSize {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskMedianOfTwoSortedArraysUnEqualSize solver = new TaskMedianOfTwoSortedArraysUnEqualSize();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskMedianOfTwoSortedArraysUnEqualSize {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		System.out.println("Enter the values of N and M . N <= M");
		int N = in.nextInt();
		int M = in.nextInt();
		int[] arrN = new int[N];
		int[] arrM = new int[M];
		
		System.out.println("Enter the elments in first array with N elements");
		for (int count = 0; count < N; count++) {
			arrN[count] = in.nextInt();
		}
		for (int count = 0; count < M; count++) {
			arrM[count] = in.nextInt();
		}
		
		double median = medianUnequalSize(arrN, 0, arrN.length - 1, arrM, 0, arrM.length - 1);
		System.out.println(median);
	}

	private double MO2(double a, double b) {
		return (a + b) / 2.;
	}
	
	private double MO3(int a, int b, int c) {
		int min = Math.min(a, Math.min(b, c));
		int max = Math.max(a, Math.max(b, c));
		return a + b + c - min - max;
	}
	
	private double MO4(int a, int b, int c, int d) {
		int min = Math.min(a, Math.min(b, Math.min(c, d)));
		int max = Math.max(a, Math.max(b, Math.max(c, d)));
		return (a + b + c + d - min - max) / 2.;
	}
	
	private double medianUnequalSize(int[] arrN, int nStart, int nEnd, int[] arrM, int mStart, int mEnd) {
		int szN = nEnd - nStart + 1;
		int szM = mEnd - mStart + 1;
		System.out.println(szN + "   " + szM);
		if (szN == 1 && szM == 1) return (arrN[nStart] + arrM[mStart]) / 2.; 
		if (szN == 1) {
			int nValue = arrN[szN - 1];
			int mid = szM / 2;
			if ((szM & 1) == 0) {				
				int beforeVal = arrM[mid - 1];
				int middleVal = arrM[mid];
				return MO3(nValue, beforeVal, middleVal);		
			} else {
				return MO2(arrM[mid], MO3(arrM[mid - 1], arrM[mid + 1], nValue));
			}
		}
		if (szN == 2) {
			int nF = arrN[szN - 2];
			int nL = arrN[szN - 1];
			int mid = szM / 2;
			if (szM == 2) {
				return MO4(nF, nL, arrM[mid], arrM[mid - 1]);
			}
			else if (szM % 2 == 0) {
				return MO4(arrM[mid], arrM[mid - 1], Math.max(nF, arrM[mid - 2]), Math.min(nL, arrM[mid + 1]));
			} else {
				return MO3(arrM[mid], Math.max(nF, arrM[mid - 1]), Math.min(nL, arrM[mid + 1]));
			}
		} 
		System.out.println((szN - 1) + "  " + (szM - 1));
		int midN = (szN - 1) / 2;
		int midM = (szM - 1) / 2;
	
		if (arrN[midN] < arrM[midM])	
			return medianUnequalSize(arrN, midN, nEnd, arrM, mStart, midM);
		return medianUnequalSize(arrN, nStart, midN, arrM, midM, mEnd);	
	}
}