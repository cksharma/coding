package easy;

/**
 * Created by cksharma on 4/5/15.
 */
public class HouseRobber {
    public int rob(int[] num) {
        if (num == null || num.length == 0) return 0;
        if (num.length == 1) return num[0];
        if (num.length == 2) return Math.max(num[0], num[1]);
        int[] dp = new int[num.length];
        for (int i = 0; i < dp.length; i++) dp[i] = num[i];

        for (int i = 0; i < num.length; i++) {
            for (int j = i - 2; j >= 0; j--) {
                dp[i] = Math.max(dp[i], num[i] + dp[j]);
            }
            if (i - 1 >= 0)
                dp[i] = Math.max(dp[i - 1], dp[i]);
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        HouseRobber sol = new HouseRobber();
        System.out.println(sol.rob(new int[]{1, 3, 1}));
    }
}
