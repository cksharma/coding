package medium;

/**
 * Created by cksharma on 9/25/15.
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
            return 0;
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = obstacleGrid[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                    if (obstacleGrid[i][j] == 1) continue;
                    dp[i][j] = 1;
                } else if (j == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                    if (obstacleGrid[i][j] == 1) continue;
                    dp[i][j] = 1;
                } else {
                    if (obstacleGrid[i][j] == 1) continue;
                    dp[i][j] =  (obstacleGrid[i][j - 1] == 0 ? dp[i][j - 1] : 0) +
                                (obstacleGrid[i - 1][j] == 0 ? dp[i - 1][j] : 0);
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        UniquePathsII uniquePathsII = new UniquePathsII();
        int[][] arr = new int[][]{
                                    {0, 0, 0},
                                    {0, 1, 0},
                                    {0, 0, 0}
                                };
        System.out.println(uniquePathsII.uniquePathsWithObstacles(arr));
    }
}
