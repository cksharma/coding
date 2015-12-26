package com.geeks.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cksharma on 12/21/15.
 */
public class ZeroOneKnapsackRecursive {
    static class Index {
        int remainingWeight;
        int remainingItems;

        Index(int remainingWeight, int remainingItems) {
            this.remainingWeight = remainingWeight;
            this.remainingItems = remainingItems;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Index index = (Index) o;

            if (remainingWeight != index.remainingWeight) return false;
            return remainingItems == index.remainingItems;

        }

        @Override
        public int hashCode() {
            int result = remainingWeight;
            result = 31 * result + remainingItems;
            return result;
        }
    }

    public static void main(String[] args) {
        int[] weight = new int[]{2, 2, 4, 5};
        int[] value = new int[]{2, 4, 6, 9};
        int W = 8;

        int maxProfit = recurseKnapsack(weight, value, W, 0, new HashMap<>());
        System.out.println("Maximum profit: " + maxProfit);
    }

    private static int recurseKnapsack(int[] weight, int[] value, int W, int curIndex, Map<Index, Integer> memo) {
        if (curIndex >= weight.length || W <= 0)
            return 0;
        int remainingWeight = W;
        int remainingItem = weight.length - curIndex;
        Index index = new Index(remainingWeight, remainingItem);
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        int max = 0;

        if (weight[curIndex] > W) {
            max =  recurseKnapsack(weight, value, W, curIndex + 1, memo);
        } else {
            int take = recurseKnapsack(weight, value, W - weight[curIndex], curIndex + 1, memo) + value[curIndex];
            int notTake = recurseKnapsack(weight, value, W, curIndex + 1, memo);
            max = Math.max(take, notTake);
        }
        memo.put(index, max);

        return max;
    }
}
