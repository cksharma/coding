import java.io.*;
import java.util.StringTokenizer;

public class Test {
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

            int[] forward = firstHalf(s, a);
            int[] backward = secondHalf(s, b);
            for (int mid = 0; mid < s.length() - 1; mid++) {
                if (forward[mid] == 0 && backward[mid + 1] == 0 && s.charAt(mid + 1) != '0') {
                    out.println("YES");
                    out.println(s.substring(0, mid + 1));
                    out.println(s.substring(mid + 1));
                    return;
                }
            }
            out.println("NO");
        }

        private int[] firstHalf(String s, int a) {  //rema[pos + 1] = (rema[pos] * 10 + C[pos + 1]) % a.
            int[] rema = new int[s.length()];
            rema[0] = (s.charAt(0) - '0') % a;
            for (int i = 0; i < s.length() - 1; i++) {
                rema[i + 1] = (rema[i] * 10 + s.charAt(i + 1) - '0') % a;
            }
            return rema;
        }

        private int[] secondHalf(String s, int b) { //remb[pos - 1] = (C[pos - 1] * P + remb[pos]) % b, where P — it is 10^(L - 1) module b
            int[] remb = new int[s.length()];
            int P = 10;
            remb[remb.length - 1] = (s.charAt(s.length() - 1) - '0') % b;
            for (int i = s.length() - 1; i > 0; i--) {
                remb[i - 1] = ((s.charAt(i - 1) - '0') * P + remb[i]) % b;
                P = (int)(((P % b) * 10L) % b);
            }
            return remb;
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