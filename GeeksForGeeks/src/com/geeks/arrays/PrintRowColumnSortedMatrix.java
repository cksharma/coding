package com.geeks.arrays;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class PrintRowColumnSortedMatrix {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		PrintRowColumnSortedMatrix_B solver = new PrintRowColumnSortedMatrix_B();
		solver.solve(1, in, out);
		out.close();
	}
}

class PrintRowColumnSortedMatrix_B {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int[][] mat = { { 10, 20, 30, 40 }, 
						{ 15, 25, 35, 45 }, 
						{ 27, 29, 37, 48 }, 
						{ 32, 33, 39, 50 } };
		
		int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
		while (x1 < mat.length && y1 < mat[0].length && x2 < mat.length && y2 < mat.length) {
			if ( (x1 + 1 == mat.length && y1 + 1 == mat[0].length) ||
					(x2 + 1 == mat.length && y2 + 1 == mat[0].length) ) {
				System.out.println(mat[x1][y1]);
				break;
			} else if (mat[x1][y1] == mat[x2][y2]) {
				//System.out.println(mat[x1][y1]);
				System.out.println(mat[x2][y2]);
				x1 = x1 + 1;
				y2 = y2 + 1;				
			} else if (mat[x1][y1] < mat[x2][y2]) {
				System.out.print(mat[x1][y1] + " ");
				x1 = x1 + 1;
			} else if (mat[x1][y1] > mat[x2][y2]) {
				System.out.print(mat[x2][y2] + " ");
				y2 = y2 + 1;
				x2 = x2 + 1;
			} else if (x1 + 1 == mat.length) {
				x1 = x2;
				y1 = y2;				
			} else if (y2 + 1 == mat[0].length) {
				x1 = x2;
				y1 = y2;				
			}
		}
	}
}