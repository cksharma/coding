package com.geeks.arrays;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class UniqueRowsBooleanMatrix {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskUniqueRowsBooleanMatrix solver = new TaskUniqueRowsBooleanMatrix();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskUniqueRowsBooleanMatrix {
	
	static class Trie {
		int data = -1;
		Trie[] trie = new Trie[2];		
	}
	
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		Trie parent = new Trie();
		int[][] arr = { {0, 1, 0, 0, 1},
						{1, 0, 1, 1, 0},
						{0, 1, 0, 0, 1},
						{1, 1, 0, 0, 1}
					  };
		for (int row = 0; row < arr.length; row++) {
			boolean isUnique = true;
			Trie tmp = parent;
			for (int col = 0; col < arr[0].length; col++) {
				int data = arr[row][col];
				
				if (tmp.trie[data] == null) {
					tmp.trie[data] = new Trie();
					tmp.trie[data].data = data;
				} else if (tmp.data == -1) {
					tmp.data = data;
				} else {
					if (col == arr[0].length - 1) {
						isUnique = false;
					}
				}
				tmp = tmp.trie[data];
			}
			if (isUnique){
				System.out.println("The row is unique " + row);
			}
		}
	}
}
