package contest322;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class TaskC {
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
            int k = in.nextInt();
            int[] arr = new int[n];
            int totalSum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                totalSum += arr[i];
            }
            if (k >= (n * 100 -totalSum) ) {
                out.println( n * 10 );
                return;
            }
            int ans = 0;
            Map<Integer, Integer> digitCountMap = new HashMap<>();
            for (int item : arr) {
                digitCountMap.put(item % 10, digitCountMap.get(item % 10) == null ? 1 : digitCountMap.get(item % 10) + 1);
                ans += item / 10;
            }
            for (int i = 9; i >= 1 && k > 0; i--) {
                int count = digitCountMap.get(i) == null ? 0 : digitCountMap.get(i);
                if (count != 0) {
                    int countNeeded = count * (10 - i);
                    if (k > countNeeded) {
                        ans += count;
                        k -= countNeeded;
                    } else {
                        ans += k / (10 - i);
                        k = 0;
                    }
                }
            }
            k = Math.max(0, k);
            out.println(ans + k / 10);
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