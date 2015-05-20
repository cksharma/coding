package contest303.c;
import java.io.*;
import java.util.Arrays;
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
    static class Pair {
        int x;
        int h;
        Pair(int x, int h) {
            this.x = x;
            this.h = h;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", h=" + h +
                    '}';
        }
    }
    private boolean canGoLeft(int pointLeft, Pair point) {
        return (point.x - point.h > pointLeft);
    }
    private boolean canGoRight(Pair point, int pointRight) {
        return point.x + point.h < pointRight;
    }

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        Pair[] pair = new Pair[n];
        for (int i = 0; i < n; i++) {
            pair[i] = new Pair(in.nextInt(), in.nextInt());
        }
        int ans = 1;
        int pointLeft = pair[0].x;

        for (int i = 1; i < n; i++) {
            if (i == n - 1 && n != 1) {
                ans++;
                continue;
            }
            if (canGoLeft(pointLeft, pair[i])) {
                ans++;
            } else if (canGoRight(pair[i], pair[i + 1].x)){
                pointLeft = pair[i].x + pair[i].h;
                ans++;
            }
            pointLeft = Math.max(pointLeft, pair[i].x);
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