import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class PractiseMain {
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
        static int[] arr = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(Stream.iterate(a, e -> e + 1)
                                        .mapToInt(Solution::getSum)
                                        .limit(b - a + 1)
                                        .sum()
            );
        }
        private static int getSum(int a) {
            int cnt = 0;
            while (a > 0) {
                cnt += arr[a % 10];
                a /= 10;
            }
            return cnt;
        }
    }

    static class InputReader {
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
}
