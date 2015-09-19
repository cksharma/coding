package medium;

/**
 * Created by cksharma on 9/16/15.
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int index1 = 0;
        int index2 = 1;
        int count = 1;
        while (index2 < nums.length) {
            if (nums[index2] != nums[index2 - 1]) {
                count = 1;
            } else {
                if (count == 2) {

                }
            }
        }
        return 0;
    }
}
