package easy;
public class ReverseInteger {
	public int reverse(int x) {
		int tmp = Math.abs(x);
		long num = 0;
		while (tmp != 0) {
			int mod = tmp % 10;
			num = num * 10 + mod;
			tmp /= 10;
		}
		if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE)
			num = 0;
		else if (x < 0)
			num *= -1;	
		return (int)num;
	}

	public static void main(String[] args) {
		ReverseInteger sol = new ReverseInteger();
		System.out.println(sol.reverse(1324));
		System.out.println(sol.reverse(0));
		System.out.println(sol.reverse(100));
		System.out.println(sol.reverse(Integer.MAX_VALUE));
		System.out.println(sol.reverse(Integer.MIN_VALUE));
		System.out.println(sol.reverse(-2147483412));
	}
}
