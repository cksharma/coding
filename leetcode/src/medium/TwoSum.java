package medium;

import java.util.Arrays;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] originalArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) originalArray[i] = nums[i];

        int[] ans = new int[2];
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                break;
            } else if (nums[start] + nums[end] > target) {
                end--;
            } else {
                start++;
            }
        }
        for (int i = 0; i < originalArray.length; i++) {
            if (start != -1 && originalArray[i] == nums[start]) {
                ans[0] = i + 1;
                start = -1;
            }
            else if (end != -1 && originalArray[i] == nums[end]) {
                ans[1] = i + 1;
                end = -1;
            }
        }
        Arrays.sort(ans);
        return ans;
    }
	
	public static void main(String[] args) {
		int[] numbers = {2, 7, 11, 15};
		int target = 9;
		TwoSum sol = new TwoSum();
        int[] ans = sol.twoSum(numbers, target);
        System.out.println(ans[0] + "  =>   " + ans[1]);

		numbers = new int[] {3,2,4};
		target = 6;
		
		ans = sol.twoSum(numbers, target);
		System.out.println(ans[0] + "  =>   " + ans[1]);
	}
}
