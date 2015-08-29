package medium;

/**
 * Created by cksharma on 8/26/15.
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        int ans = 0;
        if (nums == null || nums.length == 0) return 0;
        if (nums.length < 2) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0]; dp[1] = nums[1]; dp[2] = nums[2];

        //excluding the first element
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 2; j > 0; j--) {
                dp[i] = Math.max(dp[j] + nums[i], dp[i]);
            }
        }

        //excluding the last element
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i - 2; j >= 0; j--) {
                dp[i] = Math.max(dp[j] + nums[i], dp[i]);
            }
        }

        for (int item : dp) ans = Math.max(ans, item);
        return ans;
    }

    public static void main(String[] args) {
        HouseRobberII sol = new HouseRobberII();
        //System.out.println(sol.rob(new int[]{11, 4, 3, 12}));
        System.out.println(sol.rob(new int[]{2, 7, 9, 3, 1}));
    }
}
