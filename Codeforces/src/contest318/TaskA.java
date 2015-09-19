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

public class TaskA {
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
            int ans = 0;
            while (true) {
                int index = getMaxExceptFirstIndex(arr);
                if (arr[index] < arr[0]) break;
                arr[index]--;
                arr[0]++;
                ans++;
            }
            out.println(ans);
        }

        private int getMaxExceptFirstIndex(int[] arr) {
            int index = -1;
            int ans = Integer.MIN_VALUE;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > ans) {
                    ans = arr[i];
                    index = i;
                }
            }
            return index;
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
