package codecon.practise.laundryday;

/**
 * Created by cksharma on 4/4/15.
 */

import java.io.*;
import java.util.Comparator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Problem {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solution solver = new Solution();
        solver.solve(1, in, out);
        out.close();
    }
}

class Solution {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        Map<String, Integer> map = new TreeMap<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String s1 = o1.toString();
                String s2 = o2.toString();
                return s1.compareToIgnoreCase(s2);
            }
        });

        String str = null;
        while ((str = in.nextLine()) != null && str.length() != 0) {
            Integer count = map.get(str);
            if (count == null)
                map.put(str, 1);
            else
                map.put(str, count + 1);
        }
        for (String key : map.keySet()) {
            int cnt = map.get(key);
            if (key.contains("sock")) {
                int rem = cnt % 2;
                System.out.println(cnt / 2 + "|" + key);
                if (rem == 1 && cnt > 1)
                    System.out.println("0|" + key);
            } else {
                System.out.println(cnt + "|" + key);
            }
        }
    }
}

class InputReader {
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
