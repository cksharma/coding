package com.geeks.arrays;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class MxNMatrixTranspose {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskMxNMatrixTranspose solver = new TaskMxNMatrixTranspose();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskMxNMatrixTranspose {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		char[][] ch = { 
						{ 'a', 'b', 'c' }, 
						{ 'd', 'e', 'f' }, 
						{ 'g', 'h', 'i' }, 
						{ 'j', 'k', 'l' } 
					  };
		int rowLength = ch.length, colLength = ch[0].length;
		for (int row = 0; row < rowLength; row++) {
			for (int col = 0; col < colLength; col++) {
				
			}
		}
	}
}
