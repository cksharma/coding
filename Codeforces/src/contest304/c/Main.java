package contest304.c;

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
        int n = in.nextInt();
        int k1 = in.nextInt();
        int[] first = new int[k1];
        for(int i = 0; i < k1; i++) first[i] = in.nextInt();
        int k2 = in.nextInt();
        int[] secon = new int[k2];
        for(int i = 0; i < k2; i++) secon[i] = in.nextInt();
        int steps = 0;
        while (steps < 1000 && first.length > 0 && secon.length > 0) {
            int one = first[0];
            int two = secon[0];
            if (one < two) {
                int[] tempK1 = new int[first.length - 1];
                for (int i = 1; i < first.length; i++) tempK1[i - 1] = first[i];
                int[] tempK2 = new int[secon.length + 1];
                for (int i = 1; i < secon.length; i++) tempK2[i - 1] = secon[i];
                tempK2[secon.length - 1] = one;
                tempK2[secon.length] = two;
                first = tempK1;
                secon = tempK2;
            } else {
                int[] tempK1 = new int[first.length + 1];
                for (int i = 1; i < first.length; i++) tempK1[i - 1] = first[i];
                tempK1[first.length - 1] = two;
                tempK1[first.length] = one;
                int[] tempK2 = new int[secon.length - 1];
                for (int i = 1; i < secon.length; i++) tempK2[i - 1] = secon[i];
                first = tempK1;
                secon = tempK2;
            }
            steps++;
        }
        if (steps == 1000) {
            out.println(-1);
        } else {
            int winner = first.length == 0 ? 2 : 1;
            out.print(steps + " " + winner);
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
    public long nextLong() {
        return Long.parseLong(next());
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