package B;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem {
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
    static class State {
        int x;
        int y;
        int cost;

        State(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] arr = new int[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        int[][] cost = new int[n][m];
        ans += arr[0][0];
        for (int i = 0; i < n; i++) Arrays.fill(cost[i], (int)1e8);

        cost[0][0] = arr[0][0];
        for (int r = 0; r < 10; r++)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ( i == 0 && j == 0) continue;
                if (i - 1 >= 0)
                    cost[i][j] = Math.min(cost[i][j], cost[i - 1][j] + arr[i][j]);
                if (i + 1 < n)
                    cost[i][j] = Math.min(cost[i][j], cost[i + 1][j] + arr[i][j]);
                if (j - 1 >= 0)
                    cost[i][j] = Math.min(cost[i][j], cost[i][j - 1] + arr[i][j]);
                if (j + 1 < m)
                    cost[i][j] = Math.min(cost[i][j], cost[i][j + 1] + arr[i][j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //System.out.print(cost[i][j] + " ");
            }
            //System.out.println();
        }
        System.out.println(cost[n - 1][m - 1]);
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
