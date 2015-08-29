package com.geeks.arrays;

import java.util.Arrays;

/**
 * Created by cksharma on 8/26/15.
 */
public class MakeRowColumnZero {

    private int[][] solve(int[][] arr) {
        boolean firstRow = false, firstCol = false;
        int x = 0, y = 0;
        while (x < arr.length && y < arr[0].length) {
            for (int i = x; i < arr.length; i++)
                if (arr[i][y] == 0) { firstCol = true; break;}
            for (int i = y; i < arr[0].length; i++)
                if (arr[x][i] == 0) { firstRow = true; break;}
            if (firstCol) {
                for (int i = 0; i < arr.length; i++ ) {
                    arr[i][y] = 0;
                }
            }
            if (firstRow) {
                for (int i = 0; i < arr[0].length; i++) {
                    arr[x][i] = 0;
                }
            }
            firstCol = false;
            firstRow = false;
            x++; y++;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {{1, 2, 0, 3}, {1, 3, 2, 1}, {4, 7, 0, 3}, {5, 0, 1, 2}};
        MakeRowColumnZero sol = new MakeRowColumnZero();
        System.out.println(Arrays.deepToString(sol.solve(arr)));
    }
}
