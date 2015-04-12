import java.io.*;
import java.util.*;

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

            for (int i = 0; i < D; i++) arr[i] = in.nextInt();
            int max = Arrays.stream(arr).max().getAsInt();
            this.D = max;

            preOrder(1, 0, new int[max]);
            preOrder(2, 0, new int[max]);
            out.println("Case #" + r + ": " + ans);
        }
    }

    private void preOrder(int action, int level, int[] arr) {
        if (level == D) {
            int kk = computeAns(arr);
            if (kk < ans) {
                //for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
                //System.out.println();
                ans = kk;
            }
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
                int index = 0, runningMax = Integer.MIN_VALUE;
                for (int cks = 0; cks < list.size(); cks++) {

                    if (list.get(cks) > runningMax) {
                        index = cks;
                        runningMax = list.get(cks);
                    }
                }
                int value = list.get(index);
                list.add(value / 2);
                if (value % 2 == 1) list.set(index, value / 2 + 1);
                else list.set(index, value / 2);
            }
            int maxElement = Collections.max(list);
            if (maxElement <= 0) return k + 1;
        }

        return ans;
    }
}

class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public String nextLine() {
        String inputLine = "";
        try {
            inputLine = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputLine;
    }
}