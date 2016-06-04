package microsoft;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SolutionA {
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

            outer:
            for (int i = 0; i < 10; i++) {
                Set<Integer> st = new HashSet <>();
                int n = in.nextInt();
                int steps = 0;
                while (n != 1) {
                    int sqSum = 0;
                    st.add(n);
                    while (n != 0) {
                        sqSum += (n % 10) * (n % 10);
                        n /= 10;
                    }
                    steps++;
                    if (st.contains(sqSum)) {
                        System.out.println("unhappy " + steps);
                        continue outer;
                    }
                    n = sqSum;
                }
                System.out.println("happy " + steps);
            }
            System.out.println();
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
