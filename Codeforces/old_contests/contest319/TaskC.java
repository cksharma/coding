package contest319;

/**
 * Created by cksharma on 8/29/15.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        private List<Integer> getPrimes(int n) {
            List<Integer> ans = new ArrayList<>();
            boolean[] primes = new boolean[n + 1];
            Arrays.fill(primes, true);
            primes[0] = false;
            primes[1] = false;
            for (int i = 2; i * i <= n; i++) {
                if (primes[i]) {
                    for (int j = i * i; j <= n; j += i) {
                        primes[j] = false;
                    }
                }
            }
            for (int i = 2; i <= n; i++) {
                if (primes[i]) ans.add(i);
            }
            return ans;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();

            List<Integer> list = getPrimes(n);

            List<Integer> ans = new ArrayList<>();

            for (int item : list) {
                int x = item;
                ans.add(item);
                while ( x * item <= n) {
                    x = x * item;
                    ans.add(x);
                }
            }

            System.out.println(ans.size());

            for (int item : ans){
                System.out.print(item + " ");
            }
        }

        boolean nextPermutation(int[] a) {
            for (int i = a.length - 2; i >= 0; i--) {
                if (a[i] < a[i + 1]) {
                    reverse(a, i + 1, a.length);
                    for (int j = i + 1; ; j++) {
                        if (a[i] < a[j]) {
                            swap(a, i, j);
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        void swap(int[] a, int i, int j) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }

        void reverse(int[] a, int b, int e) {
            while (b < e) {
                e--;
                swap(a, b, e);
                b++;
            }
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
