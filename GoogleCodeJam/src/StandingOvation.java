/**
 * Created by cksharma on 4/11/15.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class StandingOvation {
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
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int T = in.nextInt();
        for (int r = 1; r <= T; r++) {
            int num = in.nextInt();
            String s = in.next();
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 1; i < s.length(); i++) {
                map.put(i, s.charAt(i) - '0');
            }
            int count = s.charAt(0) - '0';
            int newPeople = 0;
            //System.out.println(map);
            for (int key : map.keySet()) {
                if (key <= count) {
                    count += map.get(key);
                } else {
                    newPeople += key - count;
                    count += key - count + map.get(key);
                }
               // System.out.println(key + " " + count);
            }
            out.println("Case #" + r + ": " + newPeople);
        }
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
