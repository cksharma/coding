package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Pair {
    int start;
    int end;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (start != pair.start) return false;
        return end == pair.end;

    }

    @Override
    public int hashCode() {
        int result = start;
        result = 31 * result + end;
        return result;
    }

    Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class PalindromePartitioning {

    private Map<Pair, String> cacheStringPool = new HashMap<>();
    private List<List<String>> ans;
    private boolean[][] palinArr;
    private int n;

    public void solve(int start, List<String> list) {
        if ( start == n ) {
            List<String> temp = new ArrayList<>();
            for (String item : list) temp.add(item);
            ans.add(temp);
            return;
        }
        for (int e = start; e < n; e++) {
            if ( palinArr[start][e]) {
                list.add(cacheStringPool.get(new Pair(start, e)));
                solve(e + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        this.ans      = new ArrayList<>();
        this.palinArr = new boolean[s.length()][s.length()];
        this.n        = s.length();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                palinArr[i][j] = isPalinInRange(s, i, j);
                if (palinArr[i][j]) {
                    cacheStringPool.put(new Pair(i, j), s.substring(i, j + 1));
                }
            }
        }
        solve(0, new ArrayList<String>());
        return ans;
    }

    public boolean isPalinInRange(String ch, int start, int end) {
        while (start < end) {
            if (ch.charAt(start) != ch.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
		PalindromePartitioning sol = new PalindromePartitioning();
		//System.out.println(sol.partitionBruteForce("amanaplanacanalpanama"));
		//System.out.println(sol.partitionBruteForce("aab"));
        System.out.println(sol.partition("amanaplanacanalpanama"));
        System.out.println(sol.partition("aab"));
	}
}
