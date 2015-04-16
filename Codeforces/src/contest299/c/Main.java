package contest299.c;

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
        long A = in.nextInt();
        long B = in.nextInt();
        long n = in.nextInt();

        while (n-- > 0) {
            long l = in.nextInt();
            long t = in.nextInt();
            long m = in.nextInt();

            while (true) {

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
}
