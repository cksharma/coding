package contest298.a;


import java.io.*;
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
        if (n == 1 || n == 2) {
            out.println(1);
            out.println(n);
            return;
        }
        if (n == 3) {
            out.println(2);
            out.println("3 1");
            return;
        }
        StringBuilder sb = new StringBuilder();
        //out.println(n);
        for (int i = n; i >= 1; i--) {
            if (i % 2 == 1) sb.append(i + " ");
        }
        for (int i = n; i >= 1; i--) {
            if (i % 2 == 0) sb.append(i + " ");
        }
        out.println(n);
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
}