package medium;

import java.util.Arrays;

public class PerfectSquares {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 100);
        dp[0] = 0; dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = (int)Math.sqrt(i); j >= 1; j--) {
                if (j * j == i) {
                    dp[i] = 1;
                    break;
                }
                dp[i] = Math.min(dp[i], dp[j * j] + dp[i - j * j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares perfectSquares = new PerfectSquares();
        System.out.println(perfectSquares.numSquares(9));
        System.out.println(perfectSquares.numSquares(13));
        System.out.println(perfectSquares.numSquares(12));
        System.out.println(perfectSquares.numSquares(31));
        System.out.println(perfectSquares.numSquares(100));
        System.out.println(perfectSquares.numSquares(99));
        System.out.println(perfectSquares.numSquares(10000));
        System.out.println(perfectSquares.numSquares(4635));

    }
}
