import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class C274 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solution solver = new Solution();
        solver.solve(1, in, out);
        out.close();
    }

    static class ExamDay {
        int actual;
        int before;
        ExamDay(int actual, int before) {
            this.actual = actual;
            this.before = before;
        }
        @Override
        public String toString() {
            return "ExamDay{" +
                    "actual=" + actual +
                    ", before=" + before +
                    '}';
        }
    }

    static class Solution {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            ExamDay[] exams = new ExamDay[n];
            Stream  .iterate(0, i -> i + 1)
                    .limit(n)
                    .forEach(i -> exams[i] = new ExamDay(in.nextInt(), in.nextInt()));

            Arrays.sort(exams, (o1, o2) -> o1.actual != o2.actual ? o1.actual - o2.actual : o1.before - o2.before);

            int ans = 1, index = 0;
            while (index < exams.length) {
                if (ans <= exams[index].before) ans = exams[index].before;
                else ans = exams[index].actual;
                index++;
            }
            out.println(ans);
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