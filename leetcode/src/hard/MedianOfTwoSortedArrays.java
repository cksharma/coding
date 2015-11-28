package hard;

import java.util.Arrays;

/**
 * Created by cksharma on 11/28/15.
 */
public class MedianOfTwoSortedArrays {
    private double getMedianOfAnArray(int[] nums) {
        if (nums.length % 2 == 0) {
            return (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2.;
        } else {
            return nums[nums.length / 2];
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) return getMedianOfAnArray(nums2);
        if (nums2 == null || nums2.length == 0) return getMedianOfAnArray(nums1);
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        return findMedianSortedArrays(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1);
    }


    private double MO2(double a, double b) {
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

    private double MO5(int a, int b, int c, int d, int e) {
        int[] arr = new int[]{a, b, c, d, e};
        Arrays.sort(arr);
        return arr[arr.length / 2];
    }

    private double MO6(int a, int b, int c, int d, int e, int f) {
        int[] arr = new int[]{a, b, c, d, e, f};
        Arrays.sort(arr);
        return (arr[arr.length / 2 - 1] + arr[arr.length / 2]) / 2.;
    }

    private double findMedianSortedArrays(int[] arr1, int s1, int e1, int[] arr2, int s2, int e2) {
        int size1 = e1 - s1 + 1;
        int size2 = e2 - s2 + 1;
        int mid1 = (s1 + e1 + 1) / 2;
        int mid2 = (s2 + e2 + 1) / 2;
        if (size1 == 1 && size2 == 1) {
            return MO2(arr1[mid1], arr2[mid2]);
        }
        if (size1 == 1) {
            if (size2 % 2 == 1) {
                int prev = arr2[mid2 - 1];
                int mid = arr2[mid2];
                int next = arr2[mid2 + 1];
                return MO4(prev, mid, next, arr1[mid1]);
            } else {
                int prev = arr2[mid2 - 1];
                int mid = arr2[mid2];
                return MO3(prev, mid, arr2[mid2]);
            }
        }
        if (size1 == 2) {
            if (size2 % 2 == 1) {
                int fNum = arr1[mid1 - 1];
                int lNum = arr1[mid1];
                int prev = arr2[mid2 - 1];
                int mid = arr2[mid2];
                int next = arr2[mid2 + 1];
                return MO5(fNum, lNum, prev, mid, next);
            } else {
                if (size2 == 2){
                    return MO4(arr1[mid1 - 1], arr1[mid1], arr2[mid2 - 1], arr2[mid2]);
                } else {
                    int prevPrev = arr2[mid2 - 2];
                    int prev = arr2[mid2 - 1];
                    int mid = arr2[mid2];
                    int next = arr2[mid2 + 1];
                    int fNum = arr1[mid1 - 1];
                    int lNum = arr1[mid1];
                    return MO6(prevPrev, prev, mid, next, fNum, lNum);
                }
            }
        }
        if (arr1[mid1] < arr2[mid2])
            return findMedianSortedArrays(arr1, mid1, e1, arr2, s2, mid2);
        return findMedianSortedArrays(arr1, s1, mid1, arr2, mid2, e2);
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays sol = new MedianOfTwoSortedArrays();
        int[] num1 = new int[]{1, 3, 5, 7, 9, 20};
        int[] num2 = new int[]{2, 4, 6, 8, 10};
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
