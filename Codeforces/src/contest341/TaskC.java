package contest341;

import java.io.*;
import java.util.ArrayList;
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
    static class Pair<T, U> {
        T first;
        U second;
        Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }
    }
    static class Solution {
        int countPrimes(int left, int right, int p) {
            int ans = 0;
            if (left % p == 0) ans++;
            ans += (right / p - left / p);
            return ans;
        }

        int total(int left, int right) {
            return right - left + 1;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int p = in.nextInt();
            List<Pair<Integer, Integer>> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new Pair(in.nextInt(), in.nextInt()));
            }
            double nume = 0., deno = 0., ans = 0.;
            for (int i = 0; i < list.size(); i++) {
                int next = (i + 1) % n;
                int lc = list.get(i).first, rc = list.get(i).second;
                int ln = list.get(next).first, rn = list.get(next).second;

                int totalC = total(lc, rc);
                int totalN = total(ln, rn);

                int primeC = countPrimes(lc, rc, p);
                int nprimec = totalC - primeC;

                int primeN = countPrimes(ln, rn, p);
                int nprimen = totalN - primeN;

                nume = 0.; deno = 0.;
                deno += (1. * totalN * totalC);
                nume += 2. * primeN * totalC + 2.* primeC * nprimen;
                ans += nume / deno;
            }
            System.out.println(ans * 1000.);
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

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
