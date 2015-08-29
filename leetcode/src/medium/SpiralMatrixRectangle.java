package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cksharma on 8/26/15.
 */
public class SpiralMatrixRectangle {
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        // Populate result;
        int x = 0, y = 0;
        int R = a.size(), C = a.get(0).size();
        boolean[][] visited = new boolean[R][C];

        while(x < R && y < C) {
            for (int i = y; i < C; i++) {
                if (visited[x][i]) continue;
                result.add(a.get(x).get(i));
                visited[x][i] = true;
            }
            for (int i = x + 1; i < R; i++) {
                if (visited[i][C - 1]) continue;
                result.add(a.get(i).get(C - 1));
                visited[i][C - 1] = true;
            }
            for (int i = C - 2; i >= y; i--) {
                if (visited[R - 1][i]) continue;
                result.add(a.get(R - 1).get(i));
                visited[R - 1][i] = true;
            }
            for (int i = R - 2; i > x; i--) {
                if (visited[i][y]) continue;
                result.add(a.get(i).get(y));
                visited[i][y] = true;
            }
            x++;y++;
            R--;C--;
        }

        return result;
    }

    public static void main(String[] args) {
        SpiralMatrixRectangle sol = new SpiralMatrixRectangle();

        List<ArrayList<Integer>> l = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 1; i <= 16; i++) {
            temp.add(i);
            if (i % 4 == 0) {
                l.add((ArrayList<Integer>) temp.clone());
                temp.clear();
            }
        }
        System.out.println(l);
        System.out.println(sol.spiralOrder(l));
    }
}
