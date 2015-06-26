package contest304.d;

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
    int n = 5000000 + 1;
    int[] arr = new int[n];
    int[] count = new int[n];

    void preProcess() {
        for (int i = 2; i < n; i++)
            arr[i] = i;
        for (int i = 2; i * i < n; i++) {
            if (count[i] != 0)
                continue;
            for (int j = i; j < n; j += i) {
                int num = arr[j];
                while (num > 1 && num % i == 0) {
                    num /= i;
                    count[j]++;
                }
                arr[j] = num;
            }
        }

        int cumuSum = count[1];
        for (int i = 2; i < n; i++) {
            if (count[i] == 0) count[i] = 1;
            else if (arr[i] > 1) cumuSum += 1;
            cumuSum += count[i];
            count[i] = cumuSum;

        }
    }

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        preProcess();
        int t = in.nextInt();
        while (t-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            out.println(count[a] - count[b]);
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