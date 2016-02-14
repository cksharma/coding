import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Solution solver = new Solution();
        solver.solve(in, out);
        out.close();
    }

    static class Solution {
        public void solve(InputReader in, PrintWriter out) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= 1e6 - 11; i++) sb.append("7");
            sb.append("4");
            BigInteger bi = new BigInteger(sb.toString());
            int ans = bi.mod(new BigInteger("4")).intValue();
            System.out.println(ans);
            out.println(sb.toString());
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