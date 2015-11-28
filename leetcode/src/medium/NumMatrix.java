package medium;

/**
 * Created by cksharma on 11/14/15.
 */
public class NumMatrix {

    private int[][] matrix;
    private int[][] cumu;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        if (matrix.length != 0 && matrix[0].length != 0) {
            this.cumu = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++)
                for (int j = 0; j < matrix[i].length; j++) cumu[i][j] = matrix[i][j];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (j == 0) continue;
                    cumu[i][j] += cumu[i][j - 1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        for (int i = row1; i <= row2 && i < matrix.length; i++) {
            ans += matrix[i][col1] + cumu[i][col2] - cumu[i][col1];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
        System.out.println(new NumMatrix(new int[0][0]).sumRegion(0, 0, 0, 0));
    }
}
