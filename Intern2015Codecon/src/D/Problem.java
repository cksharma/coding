package D;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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
    public String getProperString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') sb.append(ch);
        }
        return sb.toString();
    }
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String str = "";
        List<String> list = new ArrayList<>();
        while ( (str = in.nextLine()) != null && str.trim().length() > 0) {
            String[] cks = str.split(" ");
            for (String item : cks) {
                if (item.trim().length() > 0) list.add(item.trim());
            }
        }
        str = list.get(0);
        //System.out.println("List size = " + list.size());
        //System.out.println(list);
        int[][] arr = new int[list.size()][str.length()];
        for (int i = 0; i < list.size(); i++) {
            String ss = list.get(i);
            ss = ss.trim();
            ss = getProperString(ss);
            for (int j = 0; j < ss.length(); j++) {
                arr[i][j] = Integer.parseInt(ss.charAt(j) + "");
            }
        }

        /*for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }*/

        double ans = 0. ;
        int n = arr.length, m = arr[0].length;
        //System.out.println(n + " " + m);
        for (int hehe = 0; hehe < 2; hehe++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int len = Math.min(n - i, m - j);
                    for (int L = len; L > 1; L--) {

                        //if (ans * ans / 2. > L * 1.) break;
                        boolean sameColLeft = true, sameColRight = true, sameRowUp = true, sameRowDown = true, sameDiag = true;
                        for (int r = i + 1; r < i + L; r++) {
                            if (arr[i][j] != arr[r][j]) {
                                sameColLeft = false;
                                break;
                            }
                        }
                        for (int r = i + 1; r < i + L; r++) {
                            if (arr[i][j] != arr[r][j + L - 1]) {
                                sameColRight = false;
                                break;
                            }
                        }
                        for (int c = j + 1; c < j + L; c++) {
                            if (arr[i][j] != arr[i][c]) {
                                sameRowUp = false;
                                break;
                            }
                        }
                        for (int c = j + 1; c < j + L; c++) {
                            if (arr[i][j] != arr[i + L - 1][c]) {
                                sameRowDown = false;
                                break;
                            }
                        }
                        for (int x = 1; x < L; x++) {
                            if (arr[i][j] != arr[i + x][j + x]) {
                                sameDiag = false;
                                break;
                            }
                        }

                        if ((sameColLeft || sameColRight) && sameDiag &&
                                (sameRowUp || sameRowDown)) {
                            ans = Math.max(((L + 1) * (L)) / 2., ans);
                            break;
                        }
                    }
                }
            }
            mirror(arr);
        }
        System.out.println(ans);
    }
    public void mirror(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length / 2; j++) {
                swap(arr[i], j, arr.length - j - 1);
            }
        }
    }

    void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
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
