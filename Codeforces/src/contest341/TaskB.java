package contest341;

import java.io.*;
import java.util.*;

public class TaskB {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solution solver = new Solution();
        solver.solve(1, in, out);
        out.close();
    }

    static class Quadruple {
        int x1, y1, x2, y2;

        Quadruple(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Quadruple quadruple = (Quadruple) o;
            return x1 == quadruple.x1 &&
                    y1 == quadruple.y1 &&
                    x2 == quadruple.x2 &&
                    y2 == quadruple.y2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x1, y1, x2, y2);
        }
    }

    static class Solution {
        private final int SIZE = 1000;
        int[][] arr = new int[SIZE + 1][SIZE + 1];

        public void solve(int testNumber, InputReader in, PrintWriter out) {

            int n = in.nextInt();
            long ans = 0;
            List<Integer> xList = new ArrayList<>();
            List<Integer> yList = new ArrayList<>();
            Map<Quadruple, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int x = in.nextInt(), y = in.nextInt();
                xList.add(x); yList.add(y);
                int[] topLeft = getTopLeft(x, y);
                int[] topRight = getTopRight(x, y);
                int[] bottomLeft = getBottomLeft(x, y);
                int[] bottomRight = getBottomRight(x, y);

                int x1 = topLeft[0], y1 = topLeft[1];
                int x2 = bottomRight[0], y2 = bottomRight[1];
                Quadruple quadruple = new Quadruple(x1, y1, x2, y2);
                if (map.containsKey(quadruple)) map.put(quadruple, map.get(quadruple) + 1);
                else map.put(quadruple, 1);

                x1 = topRight[0]; y1 = topRight[1];
                x2 = bottomLeft[0]; y2 = bottomLeft[1];
                quadruple = new Quadruple(x1, y1, x2, y2);
                if (map.containsKey(quadruple)) map.put(quadruple, map.get(quadruple) + 1);
                else map.put(quadruple, 1);
            }
            for (int i = 0; i < xList.size(); i++) {
                int x = xList.get(i);
                int y = yList.get(i);
                int[] topLeft = getTopLeft(x, y);
                int[] topRight = getTopRight(x, y);
                int[] bottomLeft = getBottomLeft(x, y);
                int[] bottomRight = getBottomRight(x, y);

                int x1 = topLeft[0], y1 = topLeft[1];
                int x2 = bottomRight[0], y2 = bottomRight[1];
                Quadruple quadruple = new Quadruple(x1, y1, x2, y2);
                Integer cnt = map.get(quadruple);
                if (cnt != null) {
                    ans += (1L * cnt * (cnt - 1) / 2);
                    map.remove(quadruple);
                }

                x1 = topRight[0]; y1 = topRight[1];
                x2 = bottomLeft[0]; y2 = bottomLeft[1];
                quadruple = new Quadruple(x1, y1, x2, y2);
                cnt = map.get(quadruple);
                if (cnt != null) {
                    ans += (1L * cnt * (cnt - 1) / 2);
                    map.remove(quadruple);
                }
            }
            System.out.println(ans);
        }

        private int[] getTopLeft(int x, int y) {
            if (x == y) return new int[]{1, 1};
            int upGo = Math.min(x, y) - 1;
            return new int[]{x - upGo, y - upGo};
        }
        private int[] getTopRight(int x, int y) {
            if (x == 1 && y == SIZE) return new int[]{1, SIZE};
            int upGo = Math.min(x - 1, SIZE - y);
            return new int[]{x - upGo, y + upGo};
        }
        private int[] getBottomLeft(int x, int y) {
            if (x == SIZE && y == 1) return new int[]{SIZE, 1};
            int bottomGo = Math.min(SIZE - x, y - 1);
            return new int[]{x + bottomGo, y - bottomGo};
        }
        private int[] getBottomRight(int x, int y) {
            if (x == SIZE && y == SIZE) return new int[]{SIZE, SIZE};
            int bottomGo = Math.min(SIZE - x, SIZE - y);
            return new int[]{x + bottomGo, y + bottomGo};
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

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
