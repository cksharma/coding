package easy;

/**
 * Created by cksharma on 9/17/15.
 */
public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int cnt = 0;
        while (true) {
            if ((n & 1) > 0) cnt++;
            n >>>= 1;
            if (n == 0) break;
        }
        return cnt;
    }

    public static void main(String[] args) {
        NumberOf1Bits sol = new NumberOf1Bits();
        System.out.println(sol.hammingWeight(1 << 31));
    }
}
