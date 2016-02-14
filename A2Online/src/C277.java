import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class C277 {
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
            int p = in.nextInt();
            String s = in.next();
            if (p > n / 2) {
                p = n - p;
            } else {
                p--;
            }

            int ans1 = forwardThenBackWard(p, s);
            int ans2 = backwardThenForward(p, s);
            out.println(min(ans1, ans2));
        }

        private int forwardThenBackWard(int p, String s) {
            int ans = 0, steps = 0;
            int start = p, lastIndex = -1;
            while (start < s.length() / 2) {
                int f = start;
                int e = s.length() - 1 - f;
                if (s.charAt(f) != s.charAt(e)) {
                    ans += distance(s.charAt(f), s.charAt(e)) + steps;
                    steps = 0;
                    lastIndex = f;
                }
                steps++;
                start++;
            }

            if (lastIndex != -1) ans += lastIndex - p;
            start = p - 1; steps = 1;
            while (start >= 0) {
                int f = start;
                int e = s.length() - 1 - f;
                if (s.charAt(f) != s.charAt(e)) {
                    ans += distance(s.charAt(f), s.charAt(e)) + steps;
                    steps = 0;
                }
                steps++;
                start--;
            }
            return ans;
        }

        private int backwardThenForward(int p, String s) {
            int ans = 0;
            int leftIndex = -1;

            int start = p - 1; int steps = 1;
            while (start >= 0) {
                int f = start;
                int e = s.length() - 1 - f;
                if (s.charAt(f) != s.charAt(e)) {
                    ans += distance(s.charAt(f), s.charAt(e)) + steps;
                    steps = 0;
                    leftIndex = f;

                }
                steps++;
                start--;
            }
            if (leftIndex != -1) ans += p - leftIndex;

            steps = 0;
            start = p;
            while (start < s.length() / 2) {
                int f = start;
                int e = s.length() - 1 - f;
                if (s.charAt(f) != s.charAt(e)) {
                    ans += distance(s.charAt(f), s.charAt(e)) + steps;
                    steps = 0;
                }
                steps++;
                start++;
            }
            return ans;
        }

        private int distance(char ch1, char ch2) {
            int mi = min(ch1, ch2);
            int ma = max(ch1, ch2);
            return min(ma - mi, mi + 26 - ma);
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
