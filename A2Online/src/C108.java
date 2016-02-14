import java.io.*;
import java.util.*;

public class C108 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Solution solver = new Solution();
        solver.solve(in, out);
        out.close();
    }

    static class Solution {
        public static final int MD = 1000000007;

        public void solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            Map<Integer, Set<Character>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String s = in.next();
                for (int j = 0; j < m; j++) {
                    Set<Character> set = map.get(j);
                    if (set == null) set = new HashSet<>();
                    set.add(s.charAt(j));
                    map.put(j, set);
                }
            }
            long ans = 1;
            for (Set<Character> set : map.values()) {
                ans = ans * set.size();
                ans %= MD;
            }
            out.println(ans);
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
