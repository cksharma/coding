package contest298.b;


import java.io.*;
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
        int v1 = in.nextInt();
        int v2 = in.nextInt();
        int t = in.nextInt();
        int d = in.nextInt();
        int ans = v1;
        t = t - 1;
        int r;

        if (d == 0) {
            out.println((t + 1) * v1);
            return;
        }

        int prevSpeed = v1;

        //This is the case for ascending
        while (t-- > 0) {
            int newSpeed = Integer.MIN_VALUE;

            for (r = d; r > 0; r--) {
                int tempSpeed = prevSpeed + r;

                if (tempSpeed <= v2) {
                    newSpeed = tempSpeed;
                    break;
                }

                int timeNeeded = (tempSpeed - v2 + d - 1) / d;
                if (timeNeeded <= t) {
                    newSpeed = tempSpeed;
                    break;
                }
            }
            if (r != 0) {
                //out.println("New Speed ascending " + newSpeed + " time = " + t);
                prevSpeed = newSpeed;
                ans += newSpeed;
                continue;
            }
            t++;
            break;
        }
        //out.println(" my answer ascending " + ans);
        //out.println(" prev speed " + prevSpeed);
        //out.println(" time left " + t);
        //Now handle the case for descending
        while (t-- > 0) {
            int newSpeed = Integer.MIN_VALUE;

            for (r = 0; r <= d; r++) {
                int tempSpeed = (prevSpeed - r);

                if (tempSpeed <= 0 || tempSpeed < v2) {
                    //out.println(" tempSpeed " + tempSpeed + " r = " + r);
                    break;
                }

                int timeNeeded = (tempSpeed - v2 + d - 1) / d;
                if (timeNeeded <= t) {
                    newSpeed = tempSpeed;
                    //out.println("New Speed descending " + newSpeed);
                    break;
                }
            }
            if (r != d + 1) {
                prevSpeed = newSpeed;
                ans += newSpeed;
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
