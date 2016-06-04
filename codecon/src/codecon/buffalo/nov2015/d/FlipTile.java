package codecon.buffalo.nov2015.d;

import java.io.*;
import java.util.*;

public class FlipTile {
    private static int getColor(int[][] grid, int[][] flip, int x, int y) {
        int color = flip[x][y] + grid[x][y];
        if (x - 1 >= 0) color += flip[x - 1][y];
        if (x + 1 < grid.length) color += flip[x + 1][y];
        if (y - 1 >= 0) color += flip[x][y - 1];
        if (y + 1 < grid[0].length) color += flip[x][y + 1];
        return color & 1;
    }
    private static int rowCount(int[][] grid, int[][]flip, int row) {
        int M = grid[0].length;
        int count = 0;
        for (int i = 0; i < M; i++) {
            if (getColor(grid, flip, row - 1, i) == 1) {
                flip[row][i]++;
                count++;
            }
        }
        return count;
    }
    private static int flipCalc(int[][]grid, int[][]flip, int i, int N, int M) {
        int configCount = 0;
        for (int j = 0; j < M; j++) {
            flip[0][j] = (i >> j) & 1;
            if (flip[0][j] == 1) configCount++;
        }
        for (int r = 1; r < N; r++) {
            Arrays.fill(flip[r], 0);
            configCount += rowCount(grid, flip, r);
        }

        for (int j = 0; j < M; j++) {
            if (getColor(grid, flip, N - 1, j) == 1) {
                return Integer.MAX_VALUE;
            }
        }
        return configCount;
    }
    private static void solve(int[][] grid, int N, int M) {
        int[][] flip = new int[N][M];
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < (1 << M); i++) {
            int count = flipCalc(grid, flip, i, N, M);
            if (count < minCount) {
                minCount = count;
            }
        }
        if (minCount == Integer.MAX_VALUE) {
            System.out.println("NaN");
        } else {
            System.out.println(minCount);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] str = in.readLine().split(" ");
        int N = Integer.parseInt(str[0]), M = Integer.parseInt(str[1]);
        int[][] grid = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] ch = in.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                grid[i][j] = ch[j] - '0';
            }
        }

        solve(grid, N, M);
    }
}