package easy;

/**
 * Created by cksharma on 9/17/15.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int digitCount = (int)Math.log10(x) + 1;
        while (x > 0) {
            int power = (int)Math.pow(10, digitCount - 1);
            int first = x / power;
            int last = x % 10;
            if (first != last) return false;
            x = x % power;
            x /= 10;
            digitCount -= 2;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeNumber sol = new PalindromeNumber();
        System.out.println(sol.isPalindrome(1000021));
        System.out.println(sol.isPalindrome(100001));
    }
}
