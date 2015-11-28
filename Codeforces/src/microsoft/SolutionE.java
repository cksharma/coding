package microsoft;

import java.io.*;
import java.util.*;

public class SolutionE {
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
            String str;
            while ((str = in.nextLine()) != null) {
                if (str.trim().length() == 0) break;
                Map<Character, Integer> map = getCharCount(str);
                int oddCount = getOddCount(map);
                if (oddCount <= 1) {
                    int sum = getPermutation(map);
                    System.out.println("0," + sum);

                } else {
                    normalize(map, oddCount);
                    int sum = getPermutation(map);
                    System.out.println(oddCount - 1 + "," + sum);
                }
            }
            System.out.println();
        }

        private int getPermutation(Map<Character, Integer> map) {
            long sumNum = 0;
            long prodDeno = 1;
            for (char ch : map.keySet()) {
                if (map.get(ch) <= 1) continue;
                sumNum += map.get(ch) / 2;
                prodDeno *= factorial((map.get(ch) / 2));
            }
            return (int)(factorial(sumNum) / prodDeno);
        }

        private long factorial(long n) {
            long ans = 1;
            for (int i = 1; i <= n; i++) {
                ans *= i;
            }
            return ans;
        }


        private void normalize(Map<Character, Integer> map, int count) {
            int localCount = 0;
            for (char ch : map.keySet()) {
                if (localCount == count - 1) break;
                if (map.get(ch) % 2 == 1) {
                    map.put(ch, map.get(ch) - 1);
                    localCount++;
                }
            }
        }



        private int getOddCount(Map<Character, Integer> map) {
            int ans = 0;
            for (char ch : map.keySet()) {
                if (map.get(ch) % 2 == 1) ans++;
            }
            return ans;
        }

        private Map<Character, Integer> getCharCount(String str) {
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : str.toCharArray()) {
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                } else {
                    map.put(ch, 1);
                }
            }
            return map;
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
