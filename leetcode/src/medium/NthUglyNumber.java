package medium;

/**
 * Created by cksharma on 8/18/15.
 */
public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        int i2 = 0, i3 = 0, i5 = 0;
        int[] arr = new int[n]; arr[0] = 1;
        int minNum = 1;

        for (int i = 1; i < n; i++) {
            int minTwo   = arr[i2] * 2;
            int minThree = arr[i3] * 3;
            int minFive  = arr[i5] * 5;
            minNum = Math.min(minTwo, Math.min(minThree, minFive));

            if (minNum == minTwo) {
                i2 = i2 + 1;
                arr[i] = minTwo;
            } if (minNum == minThree) {
                i3 = i3 + 1;
                arr[i] = minThree;
            } if (minNum == minFive) {
                i5 = i5 + 1;
                arr[i] = minFive;
            }
        }
        return minNum;
    }

    public static void main(String[] args) {
        NthUglyNumber nth = new NthUglyNumber();
        System.out.println(nth.nthUglyNumber(1));
        System.out.println(nth.nthUglyNumber(2));
        System.out.println(nth.nthUglyNumber(3));
        System.out.println(nth.nthUglyNumber(4));
        System.out.println(nth.nthUglyNumber(5));
        System.out.println(nth.nthUglyNumber(6));
        System.out.println(nth.nthUglyNumber(7));
        System.out.println(nth.nthUglyNumber(8));
        System.out.println(nth.nthUglyNumber(9));
        System.out.println(nth.nthUglyNumber(10));
    }
}
