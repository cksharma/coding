package codecon.practise.yetanothercomplaince;

/**
 * Created by cksharma on 4/4/15.
 */

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
    public boolean isPalin(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }

    private boolean isAnagramPalin(String str) {
        int[] cnt = new int[256];
        for (int i = 0; i < str.length(); i++) cnt[str.charAt(i)]++;
        int maxAllowed = str.length() % 2;
        int soFar = 0;
        for (int i = 0; i < 256; i++) {
            if (cnt[i] % 2 == 0) continue;
            soFar++;
        }
        if (soFar != maxAllowed) return false;
        return true;
    }

    private List<Integer> getFactors(int num) {
        List<Integer> ans = new LinkedList<>();
        int cnt = 2;
        while (num > 1 && num >= cnt) {
            while (num % cnt == 0) {
                ans.add(cnt);
                num /= cnt;
            }
            cnt++;
        }
        return ans;
    }

    private long getWays(String str) {
        long ans = 1;
        int[] cnt = new int[256];
        for (int i = 0; i < str.length(); i++) cnt[str.charAt(i)]++;
        List<Integer> factorsN = new LinkedList<>();
        for (int i = 2; i <= str.length() / 2; i++) {
            factorsN.addAll(getFactors(i));
        }
        List<Integer> factorsD = new LinkedList<>();
        for (int i = 0; i < 256; i++) {
            int k = cnt[i] / 2;
            for (int j = 2; j <= k; j++)
                factorsD.addAll(getFactors(j));
        }
        //System.out.println(factorsN);
        //System.out.println(factorsD);
        int[] cntN = new int[501];
        for (int i = 0; i < factorsN.size(); i++) cntN[factorsN.get(i)]++;
        for (int i = 0; i < factorsD.size(); i++) cntN[factorsD.get(i)]--;

        for (int i = 0; i < cntN.length; i++) {
            if (cntN[i] > 0) {
                ans *= Math.pow(i, cntN[i]);
            }
        }
        return ans;
    }

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String str = in.next();
        boolean ispalin = isPalin(str);
        boolean isanapalin = isAnagramPalin(str);
        if (isanapalin == false && ispalin == false) {
            out.println("0");
            return;
        }
        long ways = getWays(str);
        out.println(ways);
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
