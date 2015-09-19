package contest318;

/**
 * Created by cksharma on 8/29/15.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
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
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = in.nextInt();
            String ans = "YES";

            int rem = getRem(arr[0]);
            for (int i = 1; i < arr.length; i++) {
                int remNum = getRem(arr[i]);
                if (rem != remNum) {
                    ans = "NO";
                    break;
                }
            }
            System.out.println(ans);;
        }

        int getRem(int num) {
            while (num > 0) {
                if (num % 2 != 0 && num % 3 != 0) break;
                if (num % 2 == 0) num /= 2;
                if (num % 3 == 0) num /= 3;
            }
            return num;
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
