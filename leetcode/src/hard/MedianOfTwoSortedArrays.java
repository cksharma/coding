package hard;

import java.util.Arrays;

/**
 * Created by cksharma on 11/28/15.
 */
public class MedianOfTwoSortedArrays {

    private double medianOfSingleArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int mid = nums.length / 2;
        if (nums.length % 2 == 0)
            return (nums[mid] + nums[mid - 1]) / 2.;
        return nums[mid];
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) return 0;
        if (nums1 == null || nums1.length == 0) return medianOfSingleArray(nums2);
        if (nums2 == null || nums2.length == 0) return medianOfSingleArray(nums1);

        if (nums1.length > nums2.length)
            return median(nums2, 0, nums2.length - 1, nums1, 0, nums1.length - 1);
        return median(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1);
    }

    private double MO2(int a, int b) {
        return (a + b) / 2.;
    }

    private double MO3(int a, int b, int c) {
        int min = Math.min(a, Math.min(b, c));
        int max = Math.max(a, Math.max(b, c));
        return a + b + c - min - max;
    }

    private double MO4(int a, int b, int c, int d) {
        int min = Math.min(a, Math.min(b, Math.min(c, d)));
        int max = Math.max(a, Math.max(b, Math.max(c, d)));
        return (a + b + c + d - min - max) / 2.;
    }

    private double median(int[] nums1, int s1, int e1, int[] nums2, int s2, int e2) {
        int d1 = e1 - s1 + 1;
        int mid1 = (e1 + s1) / 2;
        int d2 = e2 - s2 + 1;
        int mid2 = (e2 + s2) / 2;

        System.out.println("s1 = " + s1 + " e1 = " + e1 + " m1 = " + mid1);
        System.out.println("s2 = " + s2 + " e2 = " + e2 + " m2 = " + mid2);

        if (d1 > d2)
            return median(nums2, s2, e2, nums1, s1, e1);

        if (nums1[mid1] == nums2[mid2]) return nums1[mid1];

        //case when d1 = 1
        if (d1 == 1 && d2 == 1) {
            return (nums1[mid1] + nums2[mid2]) / 2.;
        } else if (d1 == 1 && d2 % 2 == 0) {
            return MO3(nums1[mid1], nums2[mid2 - 1], nums2[mid2]);
        } else if (d1 == 1 && d2 % 2 == 1) {
            return MO4( nums1[mid1], nums2[mid2 - 1], nums2[mid2], nums2[mid2 + 1]);
        }

        //case when d1 == 2
        if (d1 == 2 && d2 == 2) {
            return MO4(nums1[mid1 - 1], nums1[mid1], nums2[mid2 - 1], nums2[mid2]);
        } else if (d1 == 2 && d2 % 2 == 0) {
            return MO4(Math.max(nums1[mid1 - 1], nums2[mid2 - 2]),
                    Math.min(nums1[mid1], nums2[mid2 + 1]),
                    nums2[mid2],
                    nums2[mid2 - 1]
            );
        } else if (d1 == 2 && d2 % 2 == 1) {
            return MO3(Math.max(nums1[mid1 - 1], nums2[mid2 - 1]),
                    Math.min(nums1[mid1], nums2[mid2 + 1]),
                    nums2[mid2]
            );
        }


        int k1 = mid1;
        int k2 = mid2;

        if ( (e1 - s1 + 1) % 2 == 0 && nums1[mid1] > nums2[mid2] ) {
            k1 = mid1 - 1;
        }
        if ((e2 - s2 + 1) % 2 == 0 && nums1[mid1] < nums2[mid2]) {
            k2 = mid2 - 1;
        }

        if (nums1[mid1] < nums2[mid2])
            return median(nums1, k1, e1, nums2, s2, k2);
        return median(nums1, s1, k1, nums2, k2, e2);
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays sol = new MedianOfTwoSortedArrays();
        int[] num1 = new int[]{2, 7, 8, 9};
        int[] num2 = new int[]{1, 3, 4, 5, 6, 10, 11};
        //num1 = new int[]{1, 4, 5, 7};
        //num2 = new int[]{2, 3, 6, 8};
        System.out.println(sol.findMedianSortedArrays(num1, num2));
        System.out.println(actualMedian(num1, num2));
    }

    private static double actualMedian(int[] num1, int[] num2) {
        double ans = 0.0;
        int[] arr = new int[num1.length + num2.length];
        int i = 0;
        for (; i < num1.length; i++) arr[i] = num1[i];
        for (int j = 0; j < num2.length; j++) arr[j + i] = num2[j];
        Arrays.sort(arr);
        if (arr.length % 2 == 0) {
            return (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2.;
        } else {
            return arr[arr.length / 2];
        }
    }
}
