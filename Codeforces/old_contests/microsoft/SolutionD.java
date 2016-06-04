package microsoft;

/**
 * Created by cksharma on 10/6/15.
 */

import java.io.*;
import java.util.StringTokenizer;

public class SolutionD {
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
                try {
                    String[] arr = str.trim().split(",");
                    String ss = arr[0];
                    int baseFrom = Integer.parseInt(arr[1]);
                    int baseTo = Integer.parseInt(arr[2]);
                    if (baseFrom < 2 || baseFrom > 36 || baseTo < 2 || baseTo > 36) {
                        System.out.println("Invalid Input");
                        continue;
                    }
                    long ll = Integer.parseInt(ss, baseFrom);
                    if (ll > Integer.MAX_VALUE || ll < Integer.MIN_VALUE) {
                        System.out.println("Invalid Input");
                        continue;
                    } else {
                        String ans = Integer.toString((int) ll, baseTo);
                        System.out.println(ans);
                    }
                } catch(Exception e) {
                    System.out.println("Invalid Input");
                }
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
