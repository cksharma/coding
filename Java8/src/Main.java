public class Main {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.startsWith("0")) return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            char ch = s.charAt(i - 1);
            if (ch > '0') {
                dp[i] = dp[i - 1];
            }

            char parent = s.charAt(i - 2);
            int k = Integer.parseInt("" + parent + "" + ch );
            if (k == 0) return 0;
            else if (k < 27 && k >= 10) dp[i] += dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.numDecodings("123"));
    }
}