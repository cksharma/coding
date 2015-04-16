package contest298.c;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        SolutionC solver = new SolutionC();
        solver.solve(1, in, out);
        out.close();
    }
}

class SolutionC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        long A = in.nextLong();
        int[] d = new int[n];
        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            d[i] = in.nextInt();
            totalSum += d[i];
        }
        long[] ans = new long[n];

        for (int i = 0; i < n; i++) {
            long otherMaxSum = totalSum - d[i];
            long otherMinSum = n - 1;

            long first = Math.min(d[i], A - otherMinSum);
            long secon = Math.max(1, Math.min(d[i], A - otherMaxSum));

            if (secon <= 0 || first <= 0) {
                ans[i] = 0;
                continue;
            }

            ans[i] = d[i] - (Math.abs(secon - first) + 1);

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(ans[i] + " ");

        out.println(sb.substring(0, sb.length() - 1));
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
