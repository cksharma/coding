package com.geeks.dp;

/**
 * Created by cksharma on 12/21/15.
 */
public class ZeroOneKnapsackIterative {
    public static void main(String[] args) {
        int[] weight = new int[]{2, 2, 4, 5};
        int[] value = new int[]{2, 4, 6, 9};
        int T = 8;

        int maxProfit = iterativeKnapsack(weight, value, T);
        System.out.println("Maximum profit: " + maxProfit);
    }

    private static int iterativeKnapsack(int[] weight, int[] value, int T) {

        int[][] dp = new int[weight.length + 1][T + 1];
        for (int w = 1; w <= weight.length; w++) {
            int item = weight[w - 1];
            for (int t = 1; t <= T; t++) {
                if (item <= t) {
                    dp[w][t] = Math.max(dp[w - 1][t], dp[w - 1][t - item] + value[w - 1]);
                } else {
                    dp[w][t] = dp[w - 1][t];
                }
            }
        }
        printElementsUsed(dp);
        return dp[weight.length][T];
    }
    private static void printElementsUsed(int[][] dp) {

    }
}
