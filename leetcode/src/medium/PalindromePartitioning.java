package medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    
	public List<List<String>> partition(String s) {
		List <List <String>> ans = new ArrayList <>();
		if (s == null || s.isEmpty())
			return ans;
		boolean[][] arrPalin = new boolean[s.length()][s.length()];
		char[] ch = s.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			for (int j = i; j < ch.length; j++) {
				arrPalin[i][j] = isPalin(ch, i, j);
			}
		}
		int n = s.length();
		for (int i = 1; i < (1 << n); i++) {
			List <Integer> lst = new ArrayList <>();
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) != 0) 
					lst.add(j);
			}
			int start = 0;
			boolean toTake = true;
			for (int end = 0; end < lst.size() && toTake; end++) {
				toTake = arrPalin[start][lst.get(end)];
				start = lst.get(end) + 1;
			}
			toTake = toTake & arrPalin[start - 1][s.length() - 1];
			if (toTake) {
				List <String> temp = new ArrayList <>();
				start = 0;
				for (int end = 0; end < lst.size(); end++) {
					temp.add(s.substring(start, lst.get(end) + 1));
					start = lst.get(end) + 1;
				}
				ans.add(temp);
			}
		}
		
		return ans;
    }
	
	public boolean isPalin(char[] ch, int start, int end) {
		while (start < end) {
			if (ch[start] != ch[end]) return false;
			start++;
			end--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		PalindromePartitioning sol = new PalindromePartitioning();
		List <List <String>> ans = sol.partition("amanaplanacanalpanama");
		System.out.println(ans);
	}
}
