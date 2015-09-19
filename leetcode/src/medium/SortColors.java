package medium;

public class SortColors {
    public void sortColors(int[] nums) {
        int start = 0, mid = 0, end = nums.length - 1;
        while (mid <= end) {
            if (nums[mid] == 0) {
                if (nums[start] != nums[mid])
                    swap(nums, start, mid);
                start++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                if (nums[mid] != nums[end])
                    swap(nums, mid, end);
                end--;
            }
        }
    }

    private void swap(int[] nums, int mid, int end) {
        int temp = nums[mid];
        nums[mid] = nums[end];
        nums[end] = temp;
    }

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] arr = new int[]{2, 0, 0, 1, 1, 2, 0, 0, 1};
        sortColors.sortColors(arr);
        for (int item : arr) System.out.print(item + ",");
    }
}
