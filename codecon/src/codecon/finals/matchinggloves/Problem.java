package codecon.finals.matchinggloves;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

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

    Map<String, Integer> hmap = new HashMap<String, Integer>();
    Map<String, Integer> revHmap = new HashMap<>();

    public boolean isPalin(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }

    public String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            String str = in.next();
            if (isPalin(str)) continue;
            Integer count = hmap.get(str);
            if (count == null) count = 0;
            hmap.put(str, count + 1);
                    /*String revStr = reverseString(str);
                    Integer count1 = hmap.get(revStr);
                    if (count1 == null) count1 = 0;
                    revHmap.put(revStr, count1 + 1);
                    if (hmap.containsKey(revStr) && hmap.get(revStr) > 0) {
                        ans++;
                        hmap.put(revStr, hmap.get(revStr) - 1);
                        if (hmap.get(revStr) == 0) {
                            hmap.remove(revStr);
                        }
                    } else {
                        hmap.put(str, count + 1);
                    }*/
        }
        for (String key : hmap.keySet()) {
            String newKey = reverseString(key);
            //if (hmap.containsKey(newKey) == false) continue;
            int count1 = hmap.get(key);
            Integer count2 = hmap.get(newKey);
            if (count2 == null) count2 = 0;
            //hmap.remove(key);
            //hmap.remove(newKey);
            if (count1 == count2) {
                ans += count1;
            } else {
                ans = -1;
                break;
            }
        }
        if (ans != -1) ans /= 2;
        out.println(ans);

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
}

