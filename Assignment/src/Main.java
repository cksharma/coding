import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solution solver = new Solution();
        solver.solve(1, in, out);
        out.close();
    }
}

class Solution {

    int ans;
    int D;
    int[] input;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int T = in.nextInt();
        for (int r = 1; r <= T; r++) {
            int D = in.nextInt();
            int[] arr = new int[D];
            this.input = arr;
            this.ans = Integer.MAX_VALUE;
            this.D = D;
            for (int i = 0; i < D; i++) arr[i] = in.nextInt();
            preOrder(1, 0, new int[D]);
            preOrder(2, 0, new int[D]);
            out.println("Case #" + r + ": " + ans);
        }
    }

    private void preOrder(int action, int level, int[] arr) {
        if (level == D) {
            ans = Math.min(ans, computeAns(arr));
            return;
        }
        arr[level] = action;
        preOrder(1, level + 1, arr);
        preOrder(2, level + 1, arr);
    }
    private int computeAns(int[] arr) {
        int ans = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        for (int item : input) list.add(item);

        for (int k = 0; k < arr.length; k++) {
            if (arr[k] == 1) {
                for (int i = 0; i < list.size(); i++) {
                    list.set(i, list.get(i) - 1);
                }
            } else {
                list.add(list.get(k) / 2);
                if (list.get(k) % 2 == 1) {
                    list.set(k, list.get(k) / 2 + 1);
                } else {
                    list.set(k, list.get(k) / 2);
                }
            }
            int maxElement = Arrays.stream(arr).max().getAsInt();
            if (maxElement <= 0) return k + 1;
        }

        return ans;
    }
}

