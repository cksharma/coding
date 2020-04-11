package medium;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
        String ans = "";
        char[] ch = s.toCharArray();
        for (int middle = 0; middle < ch.length; middle++) {
            int left = middle;
            int right = middle;
            while (left >= 0 && right < ch.length) {
                if (ch[left] == ch[right]) {
                    left--;
                    right++;
                } else {
                    //left++;
                    break;
                }
            }
            if (right - left - 1 > ans.length()) {
                ans = s.substring(left + 1, right);
            }
        }
        for (int even = 0; even < ch.length; even++) {
            int left = even - 1;
            int right = even;
            while (left >= 0 && right < ch.length) {
                if (ch[left] == ch[right]) {
                    left--;
                    right++;
                } else {
                    //left++;
                    break;
                }
            }
            if (right - left - 1 > ans.length()) {
                ans = s.substring(left + 1, right);
            }   
        }
        return ans;
    }
	public static void main(String[] args) {
		LongestPalindromicSubstring sol = new LongestPalindromicSubstring();
		System.out.println(sol.longestPalindrome("aaa"));
		System.out.println(sol.longestPalindrome("aab"));
		System.out.println(sol.longestPalindrome("kjhhhhkkjh"));
		System.out.println(sol.longestPalindrome("aajja"));
	}
}
