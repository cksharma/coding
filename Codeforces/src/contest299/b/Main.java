package contest299.b;


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        SolutionB solver = new SolutionB();
        solver.solve(1, in, out);
        out.close();
    }
}

class SolutionB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        long num = in.nextInt();

        Queue<Long> queue = new LinkedList<>();
        queue.add(4L); queue.add(7L);
        int index = 1;

        while (true) {
            long n = queue.poll();
            if (n >= num) {
                break;
            }
            long first = n * 10 + 4;
            long secon = n * 10 + 7;
            queue.add(first);
            queue.add(secon);
            index++;
        }
        out.println(index);
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
