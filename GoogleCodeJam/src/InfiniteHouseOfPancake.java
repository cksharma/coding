/**
 * Created by cksharma on 4/11/15.
 */

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class InfiniteHouseOfPancake {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        SolutionB solver = new SolutionB();
        solver.solve(1, in, out);
        out.close();
    }
}

class SolutionB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        testNumber = in.nextInt();
        for (int i = 1; i <= testNumber; i++) {
            int D = in.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int k = 0; k < D; k++) list.add(in.nextInt());

            int ans = 0;
            while (true) {
                Collections.sort(list, Comparator.reverseOrder());

                int maxElement = list.get(0);
                if (maxElement == 0) break;

                boolean flag = shouldHalf(list);
                if (flag == true) {
                    list.add(list.get(0) / 2);
                    list.set(0, list.get(0) / 2);
                } else {
                    for (int i1 = 0; i1 < list.size(); i1++)
                        list.set(i1, list.get(i1) - 1);
                }
                Collections.sort(list, Comparator.reverseOrder());
                System.out.println(list);
                ans++;
            }
            out.println("Case #" + i + ": " + ans);
        }
    }

    private boolean shouldHalf(ArrayList<Integer> list) {
        if (list.get(0) % 2 == 1) return false;
        int allowed = list.get(0) / 2;
        int cnt = 0;
        for (int item : list) {
            if (item > allowed) {
                cnt++;
            }
        }
        return cnt < allowed;
    }
}
