package medium;

/**
 * Created by cksharma on 11/20/15.
 */
public class SearchInRotatedSortedArrayII {

    private boolean binarySearch(int start, int end, int target, int[] nums) {
        if (start > end) return false;
        if (start == end && nums[start] != target) return false;
        int middle = (int)((0L + start + end) / 2L);
        if (nums[middle] == target) return true;

        if (middle - 1 >= 0 && nums[middle] < nums[middle - 1]) {
            if (nums[middle] > target) {
                return binarySearch(middle + 1, middle - 1, target, nums);
            }
            return binarySearch(middle + 1, end, target, nums);
        }

        if (middle + 1 < nums.length && nums[middle] > nums[middle + 1]) {
            if (nums[middle] > target) {
                return binarySearch(middle + 1, end, target, nums);
            }
            return binarySearch(start, middle - 1, target, nums);
        }


        if (nums[middle] > target) {
            return binarySearch(start, middle - 1, target, nums);
        }
        return binarySearch(middle + 1, end, target, nums);
    }

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        return binarySearch(0, nums.length - 1, target, nums);
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArrayII sol = new SearchInRotatedSortedArrayII();

        boolean flag = sol.search(new int[]{1, 1, 1, 2, 2, 4, 4, 5}, 0);
        System.out.println(flag);

        flag = sol.search(new int[]{3,1,1}, 3);
        System.out.println(flag);
    }
}
