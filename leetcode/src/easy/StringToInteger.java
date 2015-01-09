package easy;
public class StringToInteger {

	public int atoi(String str) {
		int ans = 0;
		StringBuilder res = new StringBuilder();
		str = str.trim();
		if (!str.isEmpty() && (str.charAt(0) == '-' || str.charAt(0) == '+')) {
			res.append(str.charAt(0));
			str = str.substring(1);
		}

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				res.append(str.charAt(i));
			} else {
				break;
			}
		}
		if (res.length() == 0 || (res.length() == 1 && (res.charAt(0) == '-' || res.charAt(0) == '+'))) {
			ans = 0;
		} else {
			if (res.length() >= 12 && res.charAt(0) == '-') {
				ans = Integer.MIN_VALUE;
			} else if (res.length() >= 12) {
				ans = Integer.MAX_VALUE;
			} else {
				long ck = Long.parseLong(res.toString());
				if (ck > Integer.MAX_VALUE)
					ans = Integer.MAX_VALUE;
				else if (ck < Integer.MIN_VALUE) {
					ans = Integer.MIN_VALUE;
				} else {
					ans = (int) ck;
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		StringToInteger sol = new StringToInteger();
		System.out.println(sol.atoi("12345677"));
		System.out.println(sol.atoi("99999345677"));
		System.out.println(sol.atoi("  -9223372036854775809  "));
		System.out.println(sol.atoi("  -12345677  787767"));
		System.out.println(sol.atoi("  -98abcd 123455  "));
		System.out.println(sol.atoi("  -9090909090  787767"));
		System.out.println(sol.atoi("  9090909090  787767"));
		System.out.println(sol.atoi("  +1"));
		System.out.println(sol.atoi("  -0012a42"));
	}
}
