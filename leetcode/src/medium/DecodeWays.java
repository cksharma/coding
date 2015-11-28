package medium;

/**
 * Created by cksharma on 10/13/15.
 */
public class DecodeWays {

    public int numDecodings(String s) {

        if (s == null || s.length() == 0 || s.startsWith("0")) return 0;

        if (s.length() == 1) return 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0' && (s.charAt(i - 1) >= '3' || s.charAt(i - 1) == '0')) return 0;
        }

        int[] DP = new int[s.length()];
        DP[0] = s.charAt(0) != '0' ? 1 : 0;
        DP[1] = DP[0] + (Integer.parseInt(s.substring(0, 2)) % 10 != 0 && Integer.parseInt(s.substring(0, 2)) <= 26 ? 1 : 0);

        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) != '0' && i + 1 < s.length() && s.charAt(i + 1) == '0') {
                DP[i] = DP[i - 1];
                DP[i + 1] = DP[i - 1];
                i++;
            } else if ( Integer.parseInt(s.substring(i - 1, i + 1)) <= 26 && s.charAt(i - 1) != '0' && s.charAt(i) != '0') {
                DP[i] = DP[i - 1] + DP[i - 2];
            } else if (s.charAt(i) == '0' && Integer.parseInt(s.substring(i - 2, i)) <= 26 && s.charAt(i - 1) != '0' && s.charAt(i - 2) != '0') {
                DP[i] = DP[i - 1] - 1;
            } else {
                DP[i] = DP[i - 1];
            }
        }
        return DP[s.length() - 1];
    }

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        for (int i = 1010; i < 1099; i++) {
            //System.out.println(i + "  ==> " + decodeWays.numDecodings(i + ""));
        }
        for (int i = 100; i < 199; i++) {
            //System.out.println(i + "  ==> " + decodeWays.numDecodings(i + ""));
        }
        System.out.println("  ==> " + decodeWays.numDecodings(12120 + ""));

    }
}
