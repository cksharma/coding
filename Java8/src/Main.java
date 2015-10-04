import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
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
            Map<String, String> startMap = new HashMap<>();
            Map<String, String> endMap = new HashMap<>();
            String[] str = new String[]{"My story Love", "Love story"};

            for (String item : str) {
                String[] strArr = item.split(" ");
                String first = strArr[0];
                String last = strArr[strArr.length - 1];
                if (startMap.containsKey(first)  && startMap.get(first).length() > item.length())
                    startMap.put(first, item);
                else if (startMap.containsKey(first) == false) {
                    startMap.put(first, item);
                }
                endMap.put(last, item);
            }
            int ans = Integer.MIN_VALUE;
            String ss = null;
            for (String key : startMap.keySet()) {
                if (endMap.containsKey(key)) {
                    int len = startMap.get(key).length() + key.length() + endMap.get(key).length();
                    if (len > ans) {
                        ss = endMap.get(key).substring(0, endMap.get(key).lastIndexOf(" ")) + " " +
                                         key + startMap.get(key).substring(startMap.get(key).indexOf(" "));
                        ans = len;
                    }
                }
            }
            System.out.println(ss);
            out.println(ans);
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