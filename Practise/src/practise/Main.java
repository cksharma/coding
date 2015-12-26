package practise;

import java.util.Arrays;

public class Main {

    private static int[][] rotateMatrix(int[][] grid, int flag) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] arr = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[j][i] = grid[i][j];
            }
        }

        if (flag == 0) {
            for (int i = 0; i < arr.length; i++) {
                int[] temp = arr[i];
                for (int j = 0; j < temp.length / 2; j++) {
                    int k = temp[j];
                    temp[j] = temp[temp.length - 1 - j];
                    temp[temp.length - 1 - j] = k;
                }
            }
        } else {
            for (int i = 0; i < arr.length / 2; i++) {
                int[] temp = arr[i];
                arr[i] = arr[arr.length - 1 - i];
                arr[arr.length - 1 - i] = temp;
            }
        }
        return arr;
    }

    private static void testRotateMatrix() {
        int[][] arr = new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}};
        int[][] ans = rotateMatrix(arr, 0);

        for (int[] k : arr) {
            System.out.println(Arrays.toString(k));
        }
        System.out.println();
        for (int[] k : ans){
            System.out.println(Arrays.toString(k));
        }

        System.out.println();
        ans = rotateMatrix(arr, 1);
        for (int[] k : ans){
            System.out.println(Arrays.toString(k));
        }
    }

    public static void main(String[] args) {
        //testRotateMatrix();
        System.out.println(1. / 0.);
    }
}