package contest341;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;
import static java.lang.Math.*;

public class TaskD {
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
        String[] ans = {
                "x^y^z",
                "x^z^y",
                "(x^y)^z",
                "(x^z)^y",
                "y^x^z",
                "y^z^x",
                "(y^x)^z",
                "(y^z)^x",
                "z^x^y",
                "z^y^x",
                "(z^x)^y",
                "(z^y)^x"
        };

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            BigDecimal x = new BigDecimal(in.next());
            BigDecimal y = new BigDecimal(in.next());
            BigDecimal z = new BigDecimal(in.next());
            BigDecimal[] arr = new BigDecimal[12];
            arr[0] = multiplyLog(x.doubleValue(), bigPow(y, z));
            arr[1] = multiplyLog(x.doubleValue(), bigPow(z, y));
            arr[2] = multiplyLog(x.doubleValue(), y.multiply(z));
            arr[3] = arr[2];

            arr[4] = multiplyLog(y.doubleValue(), bigPow(x, z));
            arr[5] = multiplyLog(y.doubleValue(), bigPow(z, x));
            arr[6] = multiplyLog(y.doubleValue(), x.multiply(z));
            arr[7] = arr[6];

            arr[8] = multiplyLog(z.doubleValue(), bigPow(x, y));
            arr[9] = multiplyLog(z.doubleValue(), bigPow(y, x));
            arr[10] = multiplyLog(z.doubleValue(), y.multiply(x));
            arr[11] = arr[10];

            BigDecimal res = new BigDecimal(Integer.MIN_VALUE);
            int index = 0;
            for (int i = 0; i < 12; i++) {
                if (arr[i].compareTo(res) > 0) {
                    index = i;
                    res  = arr[i];
                }
            }
            System.out.println(ans[index]);
        }

        private BigDecimal bigPow(BigDecimal a, BigDecimal b) {
            double a_double = a.doubleValue();
            int b_int = b.intValue();
            double b_fraction = b.doubleValue() - b_int;
            return a.pow(b_int).multiply(BigDecimal.valueOf(pow(a_double, b_fraction)));
        }

        private BigDecimal multiplyLog(double d, BigDecimal b) {
            BigDecimal bd = BigDecimal.valueOf(log10(d));
            return bd.multiply(b);
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
