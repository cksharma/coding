package contest297.b;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

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
        String str = in.next();
        int m = in.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) arr[i] = in.nextInt() - 1;
        Arrays.sort(arr);
        char[] ch = str.toCharArray();

        for (int i = 1; i < m; i++) {
            if (i % 2 == 1)
                reverseArrayInRange(ch, arr[i - 1], arr[i]);
        }
        if (m % 2 == 1)
            reverseArrayInRange(ch, arr[m - 1], ch.length / 2);
        out.println(new String(ch));
    }

    private void reverseArrayInRange(char[] ch, int start, int end) {
        for (int i = start; i < end; i++) {
            char temp = ch[i];
            ch[i] = ch[ch.length - 1 - i];
            ch[ch.length - 1 - i] = temp;
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
