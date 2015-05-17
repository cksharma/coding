package com.geeks.arrays;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class NumberOfIslands {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskNumberOfIslands solver = new TaskNumberOfIslands();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskNumberOfIslands {
	private boolean[][] visited;
	private int[][] arr;
	private void dfs(int row, int col) {
		visited[row][col] = true;
		if (row - 1 >= 0 && col - 1 >= 0 && arr[row - 1][col - 1] == 1 && !visited[row - 1][col - 1]) dfs(row - 1, col - 1);
		if (row - 1 >= 0 && arr[row - 1][col] == 1 && !visited[row - 1][col]) dfs(row - 1, col);
		if (row - 1 >= 0 && col + 1 < arr[0].length && arr[row - 1][col + 1] == 1 && !visited[row - 1][col + 1]) dfs(row - 1, col + 1);
		if (col + 1 < arr[0].length && arr[row][col + 1] == 1 && !visited[row][col + 1]) dfs(row, col + 1);
		if (row + 1 < arr.length && col + 1 < arr[0].length && arr[row + 1][col + 1] == 1 && !visited[row + 1][col + 1]) dfs(row + 1, col + 1);
		if (row + 1 < arr.length && arr[row + 1][col] == 1 && !visited[row + 1][col]) dfs(row + 1, col);
		if (row + 1 < arr.length && col - 1 >= 0 && arr[row + 1][col - 1] == 1 && !visited[row + 1][col - 1]) dfs(row + 1, col - 1);
		if (col - 1 >= 0 && arr[row][col - 1] == 1 && !visited[row][col - 1]) dfs(row, col - 1);
	}
	
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int[][] arr = { {1, 1, 0, 0, 0},
						{0, 1, 0, 0, 1},
						{1, 0, 0, 1, 1},
						{0, 0, 0, 0, 0},
						{1, 0, 1, 0, 1}
		    		  };
		this.arr = arr;
		visited = new boolean[arr.length][arr[0].length];
		int cnt = 0;
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				if (arr[row][col] ==1 && !visited[row][col]) {
					cnt++;
					dfs(row, col);
				}
			}
		}
		out.println(cnt);
	}	
}