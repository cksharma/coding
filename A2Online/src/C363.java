import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class C363 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Solution solver = new Solution();
        solver.solve(in, out);
        out.close();
    }

    static class Solution {
        public void solve(InputReader in, PrintWriter out) {
            String str = in.next();
            List<Integer> list = new ArrayList<>();
            int cnt = 1; int index = 1;
            while (index < str.length()) {
                if (str.charAt(index) == str.charAt(index - 1)) {
                    cnt++;
                } else {
                    list.add(cnt);
                    cnt = 1;
                }
                index++;
            }
            list.add(cnt);
            //out.println(list);
            StringBuilder sb = new StringBuilder();
            sb.append(str.charAt(0));
            if (list.get(0) >= 2) {
                sb.append(str.charAt(0));
            }
            int runningIndex = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                int prevCount = list.get(i - 1);
                int myCount = list.get(i);

                if (prevCount >= 2 && myCount >= 2) {
                    sb.append(str.charAt(runningIndex));
                    list.set(i, 1);
                } else if (myCount >= 2) {
                    sb.append(str.charAt(runningIndex)).append(str.charAt(runningIndex));
                    list.set(i, 2);
                } else if (myCount < 2) {
                    sb.append(str.charAt(runningIndex));
                }
                runningIndex += myCount;
            }
            out.println(sb.toString());
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
