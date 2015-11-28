package codecon.buffalo.nov2015.c;

/**
 * Created by cksharma on 11/19/15.
 */

import java.io.*;
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

    static class Solution {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int F = in.nextInt();
            int E = in.nextInt();
            int A = in.nextInt();
            int B = in.nextInt();

            if (A >= F || B >= F) {
                System.out.println(0);
                return;
            }
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < E; i ++) {
                int x = in.nextInt();
                int y = in.nextInt();
                int start = 0;
                List<Integer> list = new ArrayList<>();

                while (start < F) {
                    if (start >= y) {
                        list.add(start);
                    }
                    start += x;
                }
                for (int k = 0; k < list.size(); k++) {
                    int item = list.get(k);
                    List<Integer> neighbours = map.get(item);
                    List<Integer> clone = (ArrayList<Integer>)((ArrayList<Integer>) list).clone();
                    clone.remove(k);
                    if (neighbours == null) {
                        neighbours = new ArrayList<>();
                    }
                    for (int kk : clone) {
                        if (neighbours.contains(kk)) continue;
                        neighbours.add(kk);
                    }
                    map.put(item, neighbours);
                }
            }
            Queue<List<Integer>> queue = new LinkedList<>();
            if (map.get(A) != null)
                queue.add(map.get(A));
            int ans = 0;
            Set<Integer> visited = new HashSet<>();
            while (queue.size() > 0) {
                List<Integer> n = queue.poll();
                if (n == null || n.size() == 0) continue;
                if (n.contains(B)) {
                    ans = 1;
                    break;
                }
                for (int item : n) {
                    if (visited.contains(item)) continue;
                    queue.add(map.get(item));
                    visited.add(item);
                }

            }
            System.out.println(map);
            System.out.println(ans);
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

