package codecon.practise.mugcolor;

/**
 * Created by cksharma on 4/4/15.
 */

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
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
    static Set<String> set = new HashSet<>(Arrays.asList("White", "Black", "Blue", "Red", "Yellow"));

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        Set <String> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hashSet.add(in.next());
        }
        for (String color : set) {
            if (hashSet.contains(color) == false) {
                System.out.println(color);
                return;
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
