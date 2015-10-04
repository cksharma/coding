package medium;

/**
 * Created by cksharma on 9/25/15.
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0) dp[i][j] = 1;
                else if (j == 0) dp[i][j] = 1;
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(2, 2));
        System.out.println(uniquePaths.uniquePaths(3, 3));
        System.out.println(uniquePaths.uniquePaths(4, 4));
        System.out.println(uniquePaths.uniquePaths(5, 5));
        System.out.println(uniquePaths.uniquePaths(1, 10));
        System.out.println(uniquePaths.uniquePaths(100, 100));
    }
}
