package hard;

public class EditDistance {
	public int editDistance(String s1, String s2) {
		s1 = s1 == null ? "" : s1;
		s2 = s2 == null ? "" : s2;
		
		int[][] DP = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i <= s1.length(); i++)
			DP[i][0] = i;
		for (int i = 0; i <= s2.length(); i++)
			DP[0][i] = i;
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				int val = s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 : 1;
				DP[i][j] = Math.min(DP[i - 1][j - 1] + val, Math.min(DP[i - 1][j] + 1, DP[i][j - 1] + 1));
			}
		}
		return DP[s1.length()][s2.length()];
	}
	
	public int minDistance(String word1, String word2) {
		return editDistance(word1, word2);
    }
	
	public static void main(String[] args) {
		EditDistance sol = new EditDistance();
		System.out.println(sol.minDistance("hello", "elloh"));
	}
}
