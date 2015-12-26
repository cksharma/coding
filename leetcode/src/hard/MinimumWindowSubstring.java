package hard;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    class Pair {
        int left;
        int right;
        Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
        int compareTo(Pair p) {
            if (right - left < p.right - p.left) return -1;
            if (right - left > p.right - p.left) return 1;
            return 0;
        }
    }

    private Pair min(Pair p1, Pair p2) {
        if (p1.right - p1.left <= p2.right - p2.left) return p1;
        return p2;
    }

    public String minWindow(String s, String t) {
        if (t == null || s == null) return null;
        if (t.length() == 0 || s.length() == 0) return "";

        Map<Character, Integer> tStrMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) tStrMap.put(t.charAt(i), tStrMap.get(t.charAt(i)) == null ? 1 : tStrMap.get(t.charAt(i)) + 1);
        Map<Character, Integer> runMap = new HashMap<>();
        int count = 0; int leftIndex = Integer.MAX_VALUE;
        Pair pair = new Pair(0, Integer.MAX_VALUE);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (tStrMap.containsKey(ch) == false) continue;

            leftIndex = Math.min(leftIndex, i);

            int cnt = runMap.get(ch) == null ? 0 : runMap.get(ch);

            if (cnt == tStrMap.get(ch) && ch == s.charAt(leftIndex) && count == t.length()) {
                pair = min(pair, new Pair(leftIndex, i));
                leftIndex += 1;
                while (leftIndex < s.length() ) {
                    char ch1 = s.charAt(leftIndex);
                    if (tStrMap.containsKey(ch1) == false) {
                        leftIndex++;
                        continue;
                    }
                    pair = min(pair, new Pair(leftIndex, i));
                    int cnt1 = runMap.get(ch1) == null ? 0 : runMap.get(ch1);
                    if (cnt1 > tStrMap.get(ch1)) {
                        runMap.put(ch1, cnt1 - 1);
                    } else {
                        break;
                    }
                    leftIndex++;
                }
            } else {
                runMap.put(ch, cnt + 1);
                if (runMap.get(ch) <= tStrMap.get(ch)) count++;
            }
            if (count == t.length()) {
                while (leftIndex < s.length()) {
                    char ch1 = s.charAt(leftIndex);
                    if (tStrMap.containsKey(ch1) == false) {
                        leftIndex++;
                        continue;
                    }
                    int cnt1 = runMap.get(ch1);
                    if (cnt1 == tStrMap.get(ch1)) break;
                    runMap.put(ch1, cnt1 - 1);
                    leftIndex++;
                }
                pair = min(pair, new Pair(leftIndex, i));
            }
        }
        if (pair.right == Integer.MAX_VALUE) return "";
        return s.substring(pair.left, pair.right + 1);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring m = new MinimumWindowSubstring();
        System.out.println(m.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(m.minWindow("A", "A"));
        System.out.println(m.minWindow("ABFCDEFDB", "BDF"));
        System.out.println(m.minWindow("BBA", "AB"));
    }
}
