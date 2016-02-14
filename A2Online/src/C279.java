import java.io.*;
import java.util.StringTokenizer;

public class C279 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Solution solver = new Solution();
        solver.solve(in, out);
        out.close();
    }

    static class Solution {
        public void solve(InputReader in, PrintWriter out) {
            String s = in.next();
            int a = in.nextInt();
            int b = in.nextInt();

            /*if (s.startsWith("7777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777")) {
                out.println("YES");
                out.println(s.length());
                //out.println(b);
                out.println(s.substring(s.length() - 100));
                return;
            }*/

            boolean[] forward = firstHalf(s, a);
            boolean[] backward = secondHalf(s, b);
            for (int mid = 0; mid < s.length() - 1; mid++) {
                if (forward[mid] && backward[mid + 1] && s.charAt(mid + 1) != '0') {
                    out.println("YES");
                    out.println(s.substring(0, mid + 1));
                    out.println(s.substring(mid + 1));
                    return;
                }
            }
            out.println("NO");
        }

        private boolean[] firstHalf(String s, int a) {
            boolean[] forward = new boolean[s.length()];
            int rem = 0;
            for (int i = 0; i < s.length(); i++) {
                rem = rem * 10 + (s.charAt(i) - '0');
                if (rem < a) continue;
                else if (rem % a == 0) {
                    forward[i] = true;
                    int j = i + 1;
                    for (;j < s.length() && s.charAt(j) == '0'; j++) forward[j] = true;
                    i = j - 1;
                    rem = 0;
                } else {
                    rem = rem % a;
                }
            }
            return forward;
        }

        private boolean[] secondHalf(String s, long b) {
            boolean[] backward = new boolean[s.length()];
            long prod = 1, rem = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                rem = prod * (s.charAt(i) - '0') + rem;
                prod *= 10;
                if ((prod + rem) % b == 0 ) {
                    for (int k = i; k >= 0; k--) {
                        backward[k] = s.charAt(k) != '0';
                    }
                    break;
                } else if (s.charAt(i) == '0') {
                    backward[i] = false;
                } else if (rem % b == 0) {
                    backward[i] = true;
                    rem = 0;
                } else {
                    rem = rem % b;
                }
                prod %= b;
            }
            return backward;
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
