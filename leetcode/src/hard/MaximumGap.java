package hard;

/**
 * Created by cksharma on 12/30/15.
 */
public class MaximumGap {

    class RadixSort {

        private int getMaxNum(int[] nums) {
            int max = 0;
            for (int item : nums) max = Math.max(max, item);
            return max;
        }

        private void countingSortOnFactor(int[] nums, long factor) {
            int n = nums.length;
            int[] count = new int[10];
            int[] output = new int[n];

            for (int i = 0; i < nums.length; i++) {
                count[ (int)(nums[i] / factor) % 10 ]++;
            }
            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }

            for (int i = nums.length - 1; i >= 0; i--) {
                int d = (int)(nums[i] / factor) % 10;
                output[count[d] - 1] = nums[i];
                count[d]--;
            }
            for (int i = 0; i < output.length; i++) {
                nums[i] = output[i];
            }
        }

        public void applyRadixSort(int[] nums) {
            int maxNum = getMaxNum(nums);
            long factor = 1L;
            for (; factor <= maxNum; factor *= 10L) {
                countingSortOnFactor(nums, factor);
            }
        }
    }

    public int maximumGap(int[] nums) {
        RadixSort sort = new RadixSort();
        sort.applyRadixSort(nums);

        int gap = 0;
        for (int i = 1; i < nums.length; i++) {
            gap = Math.max(gap, nums[i] - nums[i - 1]);
        }
        return gap;
    }

    public static void main(String[] args) {
        MaximumGap maxGap = new MaximumGap();
        System.out.println(maxGap.maximumGap(new int[]{43,42,100,10,47}));

    }
}
