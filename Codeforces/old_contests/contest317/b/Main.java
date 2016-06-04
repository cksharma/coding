package contest317.b;

import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
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
        int n = in.nextInt();
        int s = in.nextInt();

        TreeMap<Integer, Integer> buyMap = new TreeMap<>();
        TreeMap<Integer, Integer> sellMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int dir = in.next().trim().equals("B") ? 0 : 1;
            int price = in.nextInt();
            int qty = in.nextInt();

            if ( dir == 0 && buyMap.containsKey(price)) {
                buyMap.put(price, buyMap.get(price) + qty);
            } else if (dir == 0) {
                buyMap.put(price, qty);
            }

            if ( dir == 1 && sellMap.containsKey(price)) {
                sellMap.put(price, sellMap.get(price) + qty);
            } else if (dir == 1) {
                sellMap.put(price, qty);
            }
        }
        TreeMap<Integer, Integer> sellMapNew = new TreeMap<>();
        Map<Integer, Integer> buyMapNew = buyMap.descendingMap();

        int cnt = 0;
        for (int price : sellMap.keySet()) {
            if (cnt == s) break;
            sellMapNew.put(price, sellMap.get(price));
            cnt++;
        }
        Map<Integer, Integer> sellM = sellMapNew.descendingMap();
        cnt = 0;
        for (int price : sellM.keySet()){
            if (cnt == s) break;
            System.out.println("S " + price + " " + sellM.get(price));
            cnt++;
        }
        cnt = 0;
        for (int price : buyMapNew.keySet()) {
            if (cnt == s) break;
            System.out.println("B " + price + " " + buyMapNew.get(price));
            cnt++;
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
