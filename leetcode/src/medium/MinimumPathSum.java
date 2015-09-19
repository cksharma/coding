package medium;

import java.util.Arrays;

/**
 * Created by cksharma on 9/17/15.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int[][] DP = new int[grid.length][grid[0].length];
        for (int i = 0; i < DP.length; i++) {
            Arrays.fill(DP[i], 1 << 28);
        }
        int x = 0, y = 0;
        DP[x][y] = grid[0][0];
        for (int i = 0; i < DP.length; i++) {
            for (int j = 0; j < DP.length; j++) {
                if (i == 0 && j == 0) continue;
                if (i - 1 >= 0) {
                    DP[i][j] = Math.min(DP[i][j], DP[i - 1][j] + grid[i][j]);
                }
                if (j - 1 >= 0) {
                    DP[i][j] = Math.min(DP[i][j], DP[i][j - 1] + grid[i][j]);
                }
            }
        }
        return DP[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        MinimumPathSum sol = new MinimumPathSum();
        int[][] grid = new int[][] {
                {1, 2, 3, 1, 2},
                {2, 3, 1, 4, 2},
                {5, 2, 3, 6, 1},
                {4, 3, 2, 1, 7},
                {7, 2, 3, 2, 6}
        };
        System.out.println(sol.minPathSum(grid));
    }
}
