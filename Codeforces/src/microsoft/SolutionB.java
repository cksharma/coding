package microsoft;

/**
 * Created by cksharma on 10/6/15.
 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SolutionB {
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
            for (int  i = 0; i < n; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                int c = in.nextInt();
                int d = in.nextInt();
                boolean possible = canFormDegenerateConvex(a, b, c, d);
                if (possible)
                    System.out.println("Possible");
                else
                    System.out.println("Impossible");
            }
        }

        private boolean canFormDegenerateConvex(int a, int b, int c, int d) {
            int[] arr = new int[]{a, b, c, d};
            Arrays.sort(arr);
            return arr[arr.length - 1] <= arr[0]  + arr[1] + arr[2];

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
