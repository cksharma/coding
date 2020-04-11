package contest303.d;

import java.io.*;
import java.util.Arrays;
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
        int n = in.nextInt();
        int[] T = new int[n];
        for (int i = 0; i < n; i++) T[i] = in.nextInt();
        Arrays.sort(T);
        int cumuSum = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (T[i] >= cumuSum) {
                cumuSum += T[i];
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