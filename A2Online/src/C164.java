import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class C164 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Solution solver = new Solution();
        solver.solve(in, out);
        out.close();
    }

    static class Solution {
        private int k;
        private int d;
        private int n;
        public static final int MD = 1000000007;

        public void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();
            int d = in.nextInt();

            this.n = n;
            this.k = k;
            this.d = d;
            int ans = ways(0, false, new HashMap<>());
            out.println(ans);
        }

        static class Pair {
            int sum;
            boolean include;
            Pair(int sum, boolean include) {
                this.sum = sum;
                this.include = include;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Pair pair = (Pair) o;

                if (sum != pair.sum) return false;
                return include == pair.include;
            }

            @Override
            public int hashCode() {
                int result = sum;
                result = 31 * result + (include ? 1 : 0);
                return result;
            }
        }

        private int ways(int runningSum, boolean include, Map<Pair, Integer> cache) {
            if (runningSum == n && include) {
                return 1;
            }
            if (runningSum >= n) return 0;
            Pair pair = new Pair(runningSum, include);
            if (cache.containsKey(pair)) {
                return cache.get(pair);
            }
            int ans = 0;
            for (int i = 1; i <= k; i++) {
                ans += ways(runningSum + i, include || i >= d, cache);
                ans %= MD;
            }
            cache.put(pair, ans);
            return ans;
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