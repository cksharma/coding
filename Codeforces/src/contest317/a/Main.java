package contest317.a;

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
        int nA = in.nextInt();
        int nB = in.nextInt();
        int k = in.nextInt();
        int m = in.nextInt();

        int[] A = new int[nA];
        int[] B = new int[nB];
        for (int i = 0; i < nA; i++) A[i] = in.nextInt();
        for (int i = 0; i < nB; i++) B[i] = in.nextInt();

        Arrays.sort(A);
        Arrays.sort(B);
        reverse(B, 0);

        boolean flag = A[k - 1] < B[m - 1] ;
        if (flag) System.out.println("YES");
        else System.out.println("NO");

    }

    private void reverse(int[] num, int start) {
        for (int i = 0; i < (num.length - start) / 2; i++) {
            swap(num, i + start, num.length - 1 - i);
        }
    }

    void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
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
