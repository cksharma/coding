import java.io.*;
import java.util.StringTokenizer;

public class C252 {
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
            int m = in.nextInt();
            int k = in.nextInt();
            int len = (n * m) / k;
            int lastLen = len + n * m - len * k;

            int runX = 1, runY = 1;
            boolean forward = true;
            while (k > 0) {
                int L = k == 1 ? lastLen : len;
                out.print(L + " ");
                while (L > 0) {
                    if (forward) {
                        out.print(runX + " " + runY++ + " ");
                        if (runY > m) {
                            runY = m;
                            runX++;
                            forward = false;
                        }
                    } else {
                        out.print(runX + " " + runY-- + " ");
                        if (runY < 1) {
                            runY = 1;
                            forward = true;
                            runX++;
                        }
                    }
                    L--;
                }
                out.println();
                k--;
            }
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
