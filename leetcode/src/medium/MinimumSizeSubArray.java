package medium;

import java.util.Arrays;

/**
 * Created by cksharma on 8/21/15.
 */
public class MinimumSizeSubArray {

    private int naiveApproach(int s, int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            if (sum >= s)
                return nums.length - i;
        }
        return 0;
    }

    private int optimizeWay(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int startIndex = 0; int sum = nums[0];
        int endIndex = 1; int ans = Integer.MAX_VALUE;
        while (endIndex < nums.length) {
            if (sum >= s) {
                ans = Math.min(ans, endIndex - startIndex);
                sum -= nums[startIndex];
                startIndex++;
            } else {
                sum += nums[endIndex++];
            }
        }

        while (startIndex <= endIndex && sum >= s) {
            ans = Math.min(ans, endIndex - startIndex);
            sum -= nums[startIndex];
            startIndex++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public int minSubArrayLen(int s, int[] nums) {
        //return naiveApproach(s, nums);
        return optimizeWay(s, nums);
    }

    public static void main(String[] args) {
        MinimumSizeSubArray sol = new MinimumSizeSubArray();
        //System.out.println(sol.minSubArrayLen(7, new int[]{1, 2, 3, 4,5 }));
        System.out.println(sol.minSubArrayLen(11, new int[]{1, 2, 3, 4,5 }));
    }
}
