package medium;

import java.util.Arrays;

/**
 * Created by cksharma on 10/3/15.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] arr, int target) {
        Arrays.sort(arr);
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int[] A = findClosest(arr, i, i + 1, arr.length - 1, target);
            if (A[0] < ans) {
                sum = A[1];
                ans = A[0];
            }
        }
        return sum;
    }

    public int[] findClosest(int[] arr, int start, int middle, int last, int target) {
        int ans = 1 << 20, sum = 1000;
        int[] A = new int[2];
        while (middle < last) {
            int diff = arr[start] + arr[middle] + arr[last] - target;
            if (diff == 0) {
                ans = 0;
                sum = arr[start] + arr[middle] + arr[last];
                break;
            } else if (diff < 0 && Math.abs(diff) <= ans) {
                sum = arr[start] + arr[middle] + arr[last];
                middle = middle + 1;
                ans = Math.abs(diff);

            } else if (diff < 0 && Math.abs(diff) >= ans) {
                last = last - 1;
            } else if (diff > 0 && diff <= ans) {
                sum = arr[start] + arr[middle] + arr[last];
                last = last - 1;
                ans = diff;
            } else if (diff > 0 && diff >= ans) {
                middle = middle + 1;
            }
        }
        A[0] = ans;
        A[1] = sum;
        return A;
    }

    public static void main(String[] args) {
        ThreeSumClosest sol = new ThreeSumClosest();
        int[] arr = {1, 1, 1, 0};
        int target = 100;

        System.out.println(sol.threeSumClosest(arr, target));
    }
}
