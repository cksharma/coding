import java.io.*;
import java.util.StringTokenizer;

public class A84 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Solution solver = new Solution();
        solver.solve(in, out);
        out.close();
    }

    static class Solution {
        public void solve(InputReader in, PrintWriter out) {
            int x = -1, y = 0;
            int n = in.nextInt();
            for (y = n / 4; y >= 0; y--) {
                int temp = n - 7 * y;
                if (temp >= 0 && temp % 4 == 0) {
                    x = temp / 4;
                    break;
                }
            }
            if (x == -1) out.println(x);
            else {
                for (int i = 0; i < x; i++) out.print("4");
                for (int i = 0; i < y; i++) out.print("7");
                out.println();
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
