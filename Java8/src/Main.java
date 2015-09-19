import java.util.ArrayList;

/**
 * Created by cksharma on 8/26/15.
 */
public class Main {
    public ArrayList<ArrayList<Integer>> generateMatrix(int a) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int[][] arr = new int[a][a];
        int x = 0, y = 0;
        int R = a, C = a;
        int cnt = 0;
        while (cnt < a * a) {
            for (int i = y; i < C; i++) {
                arr[x][i] = ++cnt;
            }

            for (int i = x + 1; i < R; i++) {
                arr[i][C - 1] = ++cnt;
            }

            for (int i = C - 2; i >= y; i--) {
                arr[R - 1][i] = ++cnt;
            }

            for (int i = R - 2; i > x; i--) {
                arr[i][y] = ++cnt;
            }
            R--;
            C--;
            x++;
            y++;
        }
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                temp.add(arr[i][j]);
            }
            list.add(temp);
        }
        return list;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.generateMatrix(3));
        System.out.println(main.generateMatrix(4));
    }
}

