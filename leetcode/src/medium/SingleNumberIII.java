package medium;

/**
 * Created by cksharma on 8/19/15.
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int item : nums) xor = xor ^ item;
        int diff = xor & ~(xor - 1);
        int first = 0, second = 0;
        for (int item : nums) {
            if ( (diff & item) != 0 )
                first = first ^ item;
            else
                second = second ^ item;
        }
        return new int[]{first, second};
    }

    public static void main(String[] args) {
        SingleNumberIII singleNumberIII = new SingleNumberIII();
        int[] arr = singleNumberIII.singleNumber(new int[] {1, 2, 1, 3, 2, 5});
        System.out.println(arr[0] + " " + arr[1]);
    }
}
