package com.geeks.arrays;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class TugOfWar {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskTugOfWar solver = new TaskTugOfWar();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskTugOfWar {
	private int[] arr;
	private boolean[] visited;
	private boolean[] solutions;
	private Integer minDiff;
	
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int arr[] = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
		this.arr = arr;
		int totalSum = 0;
		minDiff = new Integer(Integer.MAX_VALUE);
		for (int item : arr) totalSum += item;
		visited = new boolean[arr.length];
		solutions = new boolean[arr.length];
		tugOfWar(0, arr.length - 1, minDiff, totalSum, 0);
		solve();
	}

	private void solve() {
		for (int index = 0; index < arr.length; index++) {
			if (solutions[index] == true)
				System.out.print(arr[index] + " , ");
		}
		System.out.println();
		for (int index = 0; index < arr.length; index++) {
			if (solutions[index] == false) {
				System.out.print(arr[index] + " , ");
			}
		}
	}

	private void tugOfWar(int curPos, int size, Integer minDiff, int totalSum, int numSelected) {
		if (curPos > size) return; //nothing to do. we are simply escaping.
		if (size / 2 - numSelected > size - curPos) return; // we have ignored a couple of items.
		// and ensuring that the elements in the first group is not more than the items in the second one.
		tugOfWar(curPos + 1, size, minDiff, totalSum, numSelected);
		
		visited[curPos] = true; // I am taking the current item 
		numSelected++;
		
		if (numSelected == size / 2) { // lets check if the size is half.
			int sumSofar = 0;
			for (int i = 0; i < arr.length; i++) {
				if (visited[i]) sumSofar += arr[i];
			}
			if (Math.abs(totalSum / 2 - sumSofar) < minDiff) {
				minDiff = Math.abs(totalSum / 2 - sumSofar);
				for (int r = 0; r < size; r++) {
					solutions[r] = visited[r];
				}
				System.out.println("MIN DIFF " + minDiff);
				//System.out.println("SUM : " + sumSofar);
			}
			//tugOfWar(curPos + 1, size, minDiff, totalSum, numSelected);
		} else { //in this case, I will not decide unless size is half
			tugOfWar(curPos + 1, size, minDiff, totalSum, numSelected);
		}
		visited[curPos] = false;
	}
}
