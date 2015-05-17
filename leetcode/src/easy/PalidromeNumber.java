package easy;
public class PalidromeNumber {
	
	private long getLong(int x) {
		long ans = 0;
		while (x != 0) {
			int md = x % 10;
			ans = ans * 10 + md;
			x /= 10;
		}
		return ans;
	}
	public boolean isPalindrome(int x) {
		if (x < 0) return false;
		long ans = getLong(x);
		return ans == x;
    }

	public static void main(String[] args) {
		PalidromeNumber sol = new PalidromeNumber();
		System.out.println(sol.isPalindrome(1234321));
		System.out.println(sol.isPalindrome(Integer.MAX_VALUE));
		System.out.println(sol.isPalindrome(-1234321));
		System.out.println(sol.isPalindrome(7));
		System.out.println(sol.isPalindrome(0));
	}
}
