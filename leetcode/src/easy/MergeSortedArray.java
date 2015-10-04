package easy;

/**
 * Created by cksharma on 9/30/15.
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int endIndex = nums1.length - 1;
        int kk = m - 1;
        while (kk >= 0) {
            nums1[endIndex--] = nums1[kk--];
        }
        printArray(nums1, nums1.length);
        int i = nums1.length - m;
        int j = 0;
        int index = 0;
        while (i < nums1.length && j < n) {
            if (nums1[i] <= nums2[j]) {
                nums1[index++] = nums1[i++];
            } else {
                nums1[index++] = nums2[j++];
            }
        }
        while (i < nums1.length) nums1[index++] = nums1[i++];
        while (j < n) nums1[index++] = nums2[j++];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 4, 5, 6, 0};
        int[] nums2 = new int[]{3};
        MergeSortedArray sol = new MergeSortedArray();
        int m = 5, n = 1;
        sol.merge(nums1, m, nums2, n);

        sol.printArray(nums1, m + n);
    }
    public void printArray(int[] arr, int end) {
        for (int i = 0; i < end; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
}
