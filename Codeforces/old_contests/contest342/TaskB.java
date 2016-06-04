package contest342;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TaskB {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Solution solver = new Solution();
        solver.solve(in, out);
        out.close();
    }

    static class Solution {
        public void solve(InputReader in, PrintWriter out) {
            String first = in.next();
            String secon = in.next();
            List<Integer> v = new ArrayList<>();
            int index = 0;
            while (true) {
                index = first.indexOf(secon, index);
                if (index != -1) { v.add(index); index++; }
                else break;
            }
            int ans = 0;
            for (int i = 0; i < v.size(); i++) {
                int now = v.get(i);
                //boolean flag = false;
                while (i + 1 < v.size() && now + secon.length() > v.get(i + 1)) {
                    i++;
                    //flag = true;
                }
                //if (flag) i--;
                ans++;
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
