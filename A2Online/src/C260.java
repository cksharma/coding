import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class C260 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solution solver = new Solution();
        solver.solve(1, in, out);
        out.close();
    }
    static class Item {
        int num;
        int cnt;
        Item(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
    static class Solution {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int k = in.nextInt();
                map.put(k, map.get(k) == null ? 1 : map.get(k) + 1);
            }
            Item[] items = new Item[map.size()];
            int index = 0;
            for (int key : map.keySet()) items[index++] = new Item(key, map.get(key));
            Arrays.sort(items, (i1, i2) -> i1.num - i2.num);

            long[] dp = new long[items.length];
            for (int i = 0; i < items.length; i++) {
                int prev = i - 1 >= 0 ? items[i - 1].num : Integer.MIN_VALUE;
                int curr = items[i].num;

                if (prev + 1 == curr) {
                    long grand = i - 2 >= 0 ? dp[i - 2] : 0;
                    dp[i] = Math.max(1L * items[i].num * items[i].cnt + grand, dp[i - 1]);
                } else {
                    long parent = i - 1 >= 0 ? dp[i - 1] : 0;
                    dp[i] = parent + 1L * items[i].num * items[i].cnt;
                }
            }
            long ans = 0;
            for (long item : dp) ans = Math.max(ans, item);
            System.out.println(ans);
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
