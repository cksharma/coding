package contest318;

/**
 * Created by cksharma on 8/29/15.
 */

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class TaskB {
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

            Map<Integer, HashSet<Integer>> hmap = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                hmap.put(i, new HashSet<>());
            }
            for (int i = 0; i < m; i++) {
                int friend1 = in.nextInt();
                int friend2 = in.nextInt();

                hmap.get(friend1).add(friend2);
                hmap.get(friend2).add(friend1);
            }
            int ans = Integer.MAX_VALUE;

            for (int firstFriend : hmap.keySet()) {
                HashSet<Integer> friendsSet = hmap.get(firstFriend);
                for (int secondFriend : friendsSet) {
                    for (int thirdFriend : friendsSet) {
                        if (secondFriend != thirdFriend && hmap.get(secondFriend).contains(thirdFriend)) {
                            ans = Math.min(ans, hmap.get(firstFriend).size() + hmap.get(secondFriend).size() + hmap.get(thirdFriend).size() - 6);
                        }
                    }
                }
            }

            if (ans == Integer.MAX_VALUE) ans = -1;
            System.out.println(ans);
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
