package com.geeks.zdummy;

import java.util.Scanner;

public class SpiralArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int row = (int) Math.ceil(Math.sqrt(n));
		int[][] arr = new int[row][row];
		int x = 0, y = row - 1, cnt = 0;

		while (cnt < n) {
			for (int i = x; i <= y && cnt < n; i++) {
				cnt++;
				arr[x][i] = cnt;
			}
			for (int i = x + 1; i <= y && cnt < n; i++) {
				cnt++;
				arr[i][y] = cnt;
			}

			int temp = y;
			y = x;
			x = temp;

			for (int i = x - 1; i >= y && cnt < n; i--) {
				cnt++;
				arr[x][i] = cnt;
			}

			for (int i = x - 1; i > y && cnt < n; i--) {
				cnt++;
				arr[i][y] = cnt;
			}

			temp = y;
			y = x - 1;
			x = temp + 1;
		}
		printArray(arr);
	}

	public static void printArray(int[][] arr) {
		for (int i = 0; i < arr[0].length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				String s = arr[i][j] + "";
				while (s.length() < 4) {
					s = " " + s;
				}
				System.out.print(arr[i][j] == 0 ? "   -" : s);
			}
			System.out.println();
		}
	}
}
