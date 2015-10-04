package com.geeks.arrays;


public class BinarySearchMissing {

    private int binarySearchMissing(int start, int end, int[] arr) {

        if (start >= end) return arr[start];

        int mid = (start + end) / 2;

        if (mid - 1 >= 0 && mid + 1 < arr.length && arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1])
            return arr[mid];
        if (mid % 2 == 1 && mid - 1 >= 0 && arr[mid] != arr[mid - 1]) {
            return binarySearchMissing(start, mid - 1, arr);
        } else if (mid % 2  == 1 && mid - 1 >= 0 && arr[mid] == arr[mid - 1]) {
            return binarySearchMissing(mid + 1, end, arr);
        } else if (mid % 2 == 0 && mid + 1 < arr.length && arr[mid] != arr[mid + 1]) {
            return binarySearchMissing(start, mid - 1, arr);
        } else if (mid % 2 == 0 && mid + 1 < arr.length && arr[mid] == arr[mid + 1]) {
            return binarySearchMissing(mid + 1, end, arr);
        }
        return arr[mid];
    }

    public static void main(String[] args) {
        BinarySearchMissing sol = new BinarySearchMissing();
        //start is 0 and end is arr.length - 1 for the caller.
        // caller should handle null array case, program is not responsible for the RTE
        System.out.println(sol.binarySearchMissing(0, 7, new int[]{1, 1, 2, 2, 3, 3, 4}));
        System.out.println(sol.binarySearchMissing(0, 0, new int[]{1}));
        System.out.println(sol.binarySearchMissing(0, 2, new int[]{1, 1, 2}));
        System.out.println(sol.binarySearchMissing(0, 5, new int[]{1, 1, 2, 3, 3}));
        System.out.println(sol.binarySearchMissing(0, 10, new int[]{1, 1, 2, 3, 3, 4, 4, 5, 5, 6, 6}));
        System.out.println(sol.binarySearchMissing(0, 8, new int[]{1, 1, 2, 3, 3, 4, 4, 5, 5}));
        System.out.println(sol.binarySearchMissing(0, 8, new int[]{1, 1, 2, 2, 3, 4, 4, 5, 5}));
        System.out.println(sol.binarySearchMissing(0, 2, new int[]{1, 2, 2}));
        System.out.println(sol.binarySearchMissing(0, 4, new int[]{1, 1, 2, 2, 3}));
        System.out.println(sol.binarySearchMissing(0, 12, new int[]{1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7}));
        System.out.println(sol.binarySearchMissing(0, 6, new int[]{1, 2, 2, 3, 3, 4, 4}));
        System.out.println(sol.binarySearchMissing(0, 6, new int[]{1, 1, 2, 3, 3, 4, 4}));
    }
}
