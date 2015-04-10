package codecon.practise.baseairthmetic;

/**
 * Created by cksharma on 4/4/15.
 */

import java.io.*;
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
    private int getBase(String str) {
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A') {
                ans = Math.max(ans, str.charAt(i) - 'A' + 11);
            } else {
                ans = Math.max(ans, str.charAt(i) - '0' + 1);
            }
        }
        return ans;
    }
    private long calculate(String str) {
        int base = getBase(str);
        long ans = 0, cnt = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            int num = str.charAt(i) - '0';
            if (str.charAt(i) >= 'A') {
                num = str.charAt(i) - 'A' + 10;
            }
            ans = ans + num * (long)Math.pow(base, cnt++);
        }
        return ans;
    }

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String first = in.next();
        String secon = in.next();

        long ans = calculate(first) + calculate(secon);
        //System.out.println(calculate(first));
        //System.out.println(calculate(secon));
        System.out.println(ans);
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