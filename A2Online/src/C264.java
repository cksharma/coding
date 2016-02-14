import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class C264 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Solution solver = new Solution();
        solver.solve(in, out);
        out.close();
    }

    static class Solution {
        public void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) arr[i][j] = in.nextInt();
            Map<Integer, Long> backward = new HashMap<>();
            Map<Integer, Long> forward = new HashMap<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int back = i - j;
                    int forw = i + j;
                    Long backVal = backward.get(back) == null ? 0L : backward.get(back);
                    Long forwVal = forward.get(forw) == null ? 0L : forward.get(forw);
                    backward.put(back, backVal + arr[i][j]);
                    forward.put(forw, forwVal + arr[i][j]);
                }
            }
            long ans1 = -1, x1 = 0, y1 = 0;
            long ans2 = -1, x2 = 0, y2 = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    long val = forward.get(i + j) + backward.get(i - j) - arr[i][j];
                    int index = i + j;
                    if (index % 2 == 0 && val > ans1) {
                        ans1 = val;
                        x1 = i + 1;
                        y1 = j + 1;
                    } else if (index % 2 == 1 && val > ans2) {
                        ans2 = val;
                        x2 = i + 1;
                        y2 = j + 1;
                    }
                }
            }
            out.println(ans1 + ans2);
            out.println(x1 + " " + y1 + " " + x2 + " " + y2);
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
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
    }
}
