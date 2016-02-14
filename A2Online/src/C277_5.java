import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C277_5 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solution solver = new Solution();
        solver.solve(1, in, out);
        out.close();
    }

    static class Solution {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int m = in.nextInt();
            int s = in.nextInt();

            if (s == 0 && m == 1) {
                System.out.println("0 0");
                return;
            }
            if (s == 0 || m * 9 < s) {
                System.out.println("-1 -1");
                return;
            }

            String largest = getLargestStringDigit(m, s);
            String smallest = getSmallestStringDigit(m, s);
            System.out.println(smallest + " " + largest);
        }

        private String getLargestStringDigit(int m, int s) {
            String sb = "";
            for (int i = m - 1; i >= 0; i--) {
                int maxDigit = getMaxIntDigit(s);
                s -= maxDigit;
                sb += maxDigit;
            }
            return sb;
        }

        private int getMaxIntDigit(int s) {
            if (s < 10) return s;
            return 9;
        }


        private int getMaxIntDigitReverse(int index, int s) {
            if (index == 0) return s;
            if (s > 9) return 9;
            return s == 1 ? 0 : s - 1;
        }

        private String getSmallestStringDigit(int m, int s) {
            String sb = "";
            for (int i = m - 1; i >= 0; i--) {
                int maxReverse = getMaxIntDigitReverse(i, s);
                s -= maxReverse;
                sb = maxReverse + sb;
            }
            return sb;
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

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
}
