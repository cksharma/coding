package contest303.b;

import java.io.*;
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
}

class Solution {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String s1 = in.next();
        String s2 = in.next();
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            diff += s1.charAt(i) == s2.charAt(i) ? 0 : 1;
        }
        if (diff % 2 == 1) {
            out.println("impossible");
        } else {
            StringBuilder res = new StringBuilder("");
            boolean zero = true;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(i)) res.append(s1.charAt(i));
                else {
                    if (zero) res.append(s1.charAt(i));
                    else res.append(s2.charAt(i));
                    zero = !zero;
                }
            }
            out.println(res.toString());
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