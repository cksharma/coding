package contest297.a;

/**
 * Created by Chandra Kant on 3/26/2015.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        SolutionA solver = new SolutionA();
        solver.solve(1, in, out);
        out.close();
    }
}

class SolutionA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        String str = in.next();
        int[] arr = new int[26];
        int ans = 0;
        for (int i = 0; i < str.length(); i+= 2) {
            char key = str.charAt(i);
            char door = (char)(32 + str.charAt(i + 1));
            arr[key - 'a']++;
            if (arr[door - 'a'] > 0) {
                arr[door - 'a']--;
            } else {
                ans++;
            }
        }
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