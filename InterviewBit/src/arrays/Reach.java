package arrays;

import java.io.*;
import java.util.*;

public class Reach {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solution solver = new Solution();
        solver.solve(1, in, out);
        out.close();
    }
    static class Pair {
        int x;
        int y;
        int steps;

        public Pair(int x, int y, int steps) {
            this.x = x;
            this.y = y;
            this.steps = steps;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (x != pair.x) return false;
            return y == pair.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
    static class Solution {
        private HashSet<Pair> hset = new HashSet<>();

        int[] dx = {-1, -1, -1,  0, 0,  1, 1, 1};
        int[] dy = {-1,  0,  1, -1, 1, -1, 0, 1};

        public int bfs(int curX, int curY, int destX, int destY) {
            Queue<Pair> queue = new LinkedList<>();
            queue.add(new Pair(curX, curY, 0));
            int steps = 0;
            Pair destPair = new Pair(destX, destY, 0);
            HashSet<Pair> visited = new HashSet<>();
            while (true) {
                Pair pair = queue.poll();
                curX = pair.x;
                curY = pair.y;
                steps = pair.steps;
                if (curX == destX && curY == destY) {
                    break;
                }
                for (int i = 0; i < dx.length; i++) {
                    int newX = curX + dx[i];
                    int newY = curY + dy[i];
                    Pair newPair = new Pair(newX, newY, steps + 1);
                    if (!newPair.equals(destPair) && hset.contains(newPair) || visited.contains(newPair) ) continue;
                    queue.add(newPair);
                }
            }
            return steps;
        }

        public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
            if (X.size() == 0) return 0;
            int curX = X.get(0); int curY = Y.get(0);
            int ans = 0;

            for (int i = 0; i < X.size(); i++) {
                hset.add(new Pair(X.get(i), Y.get(i), 0));
            }

            for (int i = 1; i < X.size(); i++) {
                ans += bfs(curX, curY, X.get(i), Y.get(i));
                curX = X.get(i);
                curY = Y.get(i);
            }
            return ans;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            //ArrayList<Integer> X = new ArrayList<>();X.add(0);X.add(1);X.add(1);
            //ArrayList<Integer> Y = new ArrayList<>();Y.add(0);Y.add(1);Y.add(2);
            //System.out.println(coverPoints(X, Y));

            ArrayList<Integer> X = new ArrayList<>();X.add(4);X.add(8);X.add(-7);X.add(-5);X.add(-13);X.add(9);X.add(-7);X.add(8);
            ArrayList<Integer> Y = new ArrayList<>();Y.add(4);Y.add(-15);Y.add(-10);Y.add(-3);Y.add(-13);Y.add(12);Y.add(8);Y.add(-8);
            System.out.println(coverPoints(X, Y));
        }
    }

    static class InputReader {
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
}
