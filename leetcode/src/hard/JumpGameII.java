package hard;

import java.util.Arrays;

/**
 * Created by cksharma on 9/18/15.
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int[] DP = new int[nums.length];
        Arrays.fill(DP, 1 << 28);
        DP[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < Math.min(nums.length, nums[i]); j++) {
                DP[j] = Math.min(DP[j], DP[i] + 1);
            }
        }
        
        return DP[nums.length - 1];
    }
}
