import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Map;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskC {
        private int nb;
        private int ns;
        private int nc;
        private int pb;
        private int ps;
        private int pc;
        long r;
        Map<Character, Integer> map;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            String s = in.next();
            this.nb = in.nextInt();
            this.ns = in.nextInt();
            this.nc = in.nextInt();
            this.pb = in.nextInt();
            this.ps = in.nextInt();
            this.pc = in.nextInt();
            this.r = Long.parseLong(in.next());

            this.map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), map.get(s.charAt(i)) == null ? 1 : map.get(s.charAt(i)) + 1);
            }

            long low = 0, high = (long) 1e12;

            while (low < high) {
                long middle = (low + high) / 2;

                if (low == middle && isPossible(high)) {
                    low = high;
                    break;
                } else if (low == middle) break;

                if (isPossible(middle)) {
                    low = middle;
                } else {
                    high = middle - 1;
                }
            }
            out.println(low);
        }

        private boolean isPossible(long num) {
            long extraBCost = map.get('B') == null ? 0 : num * map.get('B') * pb - nb * pb;
            extraBCost = extraBCost < 0 ? 0 : extraBCost;

            long extraSCost = map.get('S') == null ? 0 : num * map.get('S') * ps - ns * ps;
            extraSCost = extraSCost < 0 ? 0 : extraSCost;

            long extraCCost = map.get('C') == null ? 0 : num * map.get('C') * pc - nc * pc;
            extraCCost = extraCCost < 0 ? 0 : extraCCost;

            return (extraBCost + extraSCost + extraCCost <= r);
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

    }
}

