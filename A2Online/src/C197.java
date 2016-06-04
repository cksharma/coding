import java.io.*;
import java.util.*;

public class C197 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Solution solver = new Solution();
        solver.solve(in, out);
        out.close();
    }

    static class State {
        int prev;
        int leftSum;
        int rightSum;

        public State(int prev, int leftSum, int rightSum) {
            this.prev = prev;
            this.leftSum = leftSum;
            this.rightSum = rightSum;
        }

        @Override
        public String toString() {
            return "State{" +
                    "prev=" + prev +
                    ", leftSum=" + leftSum +
                    ", rightSum=" + rightSum +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return prev == state.prev &&
                    leftSum == state.leftSum &&
                    rightSum == state.rightSum;
        }

        @Override
        public int hashCode() {
            return Objects.hash(prev, leftSum, rightSum);
        }
    }
    static class Solution {

        private String str;
        private int m;
        private List<Integer> list;

        public void solve(InputReader in, PrintWriter out) {
            str = in.next();
            list = new ArrayList<>();
            m = in.nextInt();
            for (int i = 0; i < str.length(); i++) if (str.charAt(i) != '0' ) list.add(i + 1);

            List<Integer> res = new ArrayList<>();
            if (dfs(0, 0, res)) {
                out.println("YES");
                for (int item : res) out.print(item + " ");
            } else {
                out.println("NO");
            }
        }

        private Map<State, Boolean> cache = new HashMap<>();

        private boolean dfs(int leftSum, int rightSum, List<Integer> res) {
            if (res.size() == m) {
                return true;
            }
            boolean leftKoTurn = res.size() % 2 == 0;
            boolean able = false;
            int prev = res.size() == 0 ? 0 : res.get(res.size() - 1);

            State state = new State(prev, leftSum, rightSum);
            if (cache.containsKey(state)) return cache.get(state);

            for (int i = 0; i < list.size() && !able; i++) {
                int item = list.get(i);
                if (leftKoTurn && item != prev && leftSum + item > rightSum) {
                    res.add(item);
                    able = dfs(leftSum + item, rightSum, res);
                    if (able == false && res.size() > 0) res.remove(res.size() - 1);
                } else if ( !leftKoTurn && item != prev && rightSum + item > leftSum) {
                    res.add(item);
                    able = dfs(leftSum, rightSum + item, res);
                    if (able == false && res.size() > 0) res.remove(res.size() - 1);
                }
            }
            cache.put(state, able);
            return able;
        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
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
}
