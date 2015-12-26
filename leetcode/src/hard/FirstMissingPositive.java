package hard;

/**
 * Created by cksharma on 12/12/15.
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[j] <= 0) { j--; continue; }
            if (nums[i] > 0)  { i++; continue;  }
            swap(nums, i, j);
        }
        int startIndex = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) break;
        }
        int endIndex = i;

        int ans = endIndex + 1;
        for (i = startIndex; i < endIndex; i++) {
            int nn = Math.abs(nums[i]);
            if (nn > endIndex || nums[nn - 1] < 0) continue;
            nums[nn - 1] = -nums[nn - 1];
        }
        for (i = 1; i <= endIndex; i++) {
            if (nums[i - 1] > 0) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        FirstMissingPositive sol = new FirstMissingPositive();
        int[] arr = new int[]{3, 4, -1, 1};
        arr = new int[]{1,2,0};
        int ans = sol.firstMissingPositive(arr);
        System.out.println("First missing +ve " + ans);
    }
}
