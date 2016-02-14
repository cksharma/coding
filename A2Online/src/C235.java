import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C235 {
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
            int n = in.nextInt();
            int m = in.nextInt();

            if (startWithZero(n, m)) {
                fillWithStartZero(n, m, out);
            } else if (startWithOne(n, m)) {
                fillWithStartOne(n, m, out);
            } else {
                System.out.println(-1);
            }
        }
        private void fillWithStartZero(int n, int m, PrintWriter out) {
            int[] arr = new int[3 * n];
            Arrays.fill(arr, Integer.MIN_VALUE);
            for (int i = 0; i < n; i++) {
                arr[3 * i] = 0;
                arr[3 * i + 1] = 1;
            }
            for (int i = 0; i < m - n; i++) {
                arr[3 * i + 2] = 1;
            }
            int cnt = 0;
            for (int i = 0; i < arr.length && cnt < n + m; i++) {
                if (arr[i] < 0) continue;
                out.print(arr[i]);
                cnt++;
            }
            out.println();
        }
        private void fillWithStartOne(int n, int m, PrintWriter out) {
            int[] arr = new int[3 * n + 2];
            Arrays.fill(arr, Integer.MIN_VALUE);
            arr[0] = 1;
            for (int i = 0; i < n; i++) {
                arr[i * 3 + 2] = 0;
                arr[i * 3 + 3] = 1;
            }
            for (int i = 0; i < m - n - 1; i++) {
                arr[i * 3 + 1] = 1;
            }
            int cnt = 0;
            for (int i = 0; i < arr.length && cnt < n + m; i++) {
                if (arr[i] < 0) continue;
                out.print(arr[i]);
                cnt++;
            }
            out.println();
        }
        private boolean startWithZero(int n, int m) {
            int minM = n - 1, maxM = 2 * n;
            return m >= minM && m <= maxM;
        }
        private boolean startWithOne(int n, int m) {
            int minM = n, maxM = 2 * (n + 1);
            return m >= minM && m <= maxM;
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
