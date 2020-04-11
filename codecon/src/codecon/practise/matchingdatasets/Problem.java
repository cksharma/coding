package codecon.practise.matchingdatasets;

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
    private String getClosestString(Map<String, Integer> map, String str) {
        String ans = "";
        int diff = Integer.MAX_VALUE;
        for (String key : map.keySet()) {
            String[] arr1 = key.split(",");
            String[] arr2 = str.split(",");
            int cnt = 0;
            for (int k = 0; k < arr1.length; k++) {
                if (arr1[k].equals(arr2[k])) continue;
                cnt++;
            }
            if (cnt < diff) {
                ans = key;
                diff = cnt;
            }
        }

        return ans;
    }
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int k = in.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < k; i++) list.add(in.next());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) map.put(in.next(), i);
        int cnt = 0;
        for (String str : list) {
            String closestStr = getClosestString(map, str);
            System.out.println(cnt++ + "," + map.get(closestStr));
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