package medium;

import java.util.Arrays;

/**
 * Created by cksharma on 10/3/15.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] arr, int target) {
        Arrays.sort(arr);
        int diff = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            int j = i + 1, k = arr.length - 1;
            while (j < k) {
                int targetSum = arr[i] + arr[j] + arr[k];

                int localDiff = Math.abs(target - targetSum);

                if (localDiff == 0) return targetSum;

                if (localDiff < diff) {
                    diff = localDiff;
                    sum = targetSum;
                }
                if (targetSum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ThreeSumClosest sol = new ThreeSumClosest();
        int[] arr = {1, 1, 1, 0};
        int target = 100;

        System.out.println(sol.threeSumClosest(arr, target));
    }
}
