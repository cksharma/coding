package contest303.a;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
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
        int[][] A = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                A[i][j] = in.nextInt();
        Set set = new HashSet();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i][j] == -1) continue;
                if (A[i][j] == 1) set.add(i + 1);
                else if (A[i][j] == 2) set.add(j + 1);
                else if (A[i][j] == 3) {
                    set.add(i + 1);
                    set.add(j + 1);
                }
            }
        }

        int count = n - set.size();
        out.println(count);
        for (int i = 1; i <= n; i++) {
            if (set.contains(i)) continue;
            out.print(i + " ");
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