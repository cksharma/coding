package codecon.finals.golfcourse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

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
        int val;
        int steps;
        State(int val, int steps) {
            this.val = val;
            this.steps = steps;
        }

        @Override
        public String toString() {
            return "State{" +
                    "val=" + val +
                    ", steps=" + steps +
                    '}';
        }
    }

    int[][] arr = new int[][] {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {-1, 0, -1}
    };

    static Map<Integer, int[]> map = new HashMap<Integer, int[]>() {{
        put(1, new int[] {6, 8});
        put(2, new int[] {7, 9});
        put(3, new int[] {4, 8});
        put(4, new int[] {0, 3, 9});
        put(5, new int[] {});
        put(6, new int[] {0, 1, 7});
        put(7, new int[] {2, 6});
        put(8, new int[] {1, 3});
        put(9, new int[] {2, 4});
        put(0, new int[] {4, 6});
    }};

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int ans = 0;

        State initial = new State(1, 0);
        Queue<State> queue = new LinkedList<State>();
        queue.add(initial);
        while (queue.isEmpty() == false) {
            State state = queue.poll();
            int val = state.val;
            int steps = state.steps;

            //System.out.println(state);

            if (steps > n) continue;

            if (steps == n && val == 9) {
                ans++;
            }

            int[] neighbours = map.get(val);
            for (int item : neighbours) {
                queue.add(new State(item, steps + 1));
            }

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
}
