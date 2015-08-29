package medium;

import java.util.Arrays;

/**
 * Created by cksharma on 8/26/15.
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 ) return;
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];
                matrix[first][i] = matrix[last-offset][first];
                matrix[last-offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last] = top;
            }
        }
    }

    public static void main(String[] args) {
        RotateImage sol = new RotateImage();
        int[][] arr = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        sol.rotate(arr);
        System.out.println(Arrays.deepToString(arr));
    }
}
