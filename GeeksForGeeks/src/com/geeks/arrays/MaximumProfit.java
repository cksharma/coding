package com.geeks.arrays;

public class MaximumProfit {

	private static int solve(int[] profit, double time) {
		int start = 0;
		int runningProfit = 0;
		int currentIndex = 0;
		int maxProfit = 0;

		while (start < profit.length) {
			if (time >= 0.5) {
				runningProfit += profit[currentIndex];
				time -= 0.5;
			} else {
				runningProfit += profit[currentIndex] - profit[start];
				start++;
			}
			currentIndex = (currentIndex + 1) % profit.length;
			maxProfit = Math.max(maxProfit, runningProfit);
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		int[] profit = { 1, 9, 3, 5, 6, 10, 2, 4 };
		int time = 2;

		int p = solve(profit, time);
		System.out.println("Profit " + p);
	}
}