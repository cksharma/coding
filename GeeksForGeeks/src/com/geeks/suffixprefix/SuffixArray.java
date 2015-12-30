package com.geeks.suffixprefix;

import java.util.Arrays;
import java.util.Comparator;

public class SuffixArray {

    class SuffixSort implements Comparator<Integer> {
        char[] original;

        SuffixSort(char[] original) {
            this.original = original;
        }

        @Override
        public int compare(Integer o1, Integer o2) {
            while (o1 < original.length && o2 < original.length && original[o1] == original[o2]) {
                o1++;
                o2++;
            }

            if (o1 == original.length && o2 == original.length) {
                return 0;
            }

            if (o1 == original.length) {
                return -1;
            }

            if (o2 == original.length) {
                return 1;
            }
            return original[o1] < original[o2] ? -1 : 1;
        }
    }

    private Integer[] constructSuffixArray(char[] original) {
        SuffixSort sort = new SuffixSort(original);
        Integer[] arr = new Integer[original.length];
        for (int i = 0; i < original.length; i++) {
            arr[i] = i;
        }
        Arrays.sort(arr, sort);
        return arr;
    }

    private void printSortedSuffixes(Integer[] result, char[] original) {
        String str = new String(original);
        for (int index : result) {
            System.out.println(index + ": " + str.substring(index));
        }
        System.out.println();
    }

    private int compareStrings(char[] original, char[] substring, int mid) {
        int i = 0;
        while (i < substring.length && mid < original.length && substring[i] == original[mid]) {
            i++;
            mid++;
        }
        if (i == substring.length) {
            return 0;
        }
        if (mid == original.length) {
            return -1;
        }
        return original[mid] < substring[i] ? -1 : 1;
    }

    private int findMatchingSubstring(char[] original, char[] substring, Integer[] result) {
        int low = 0, high = original.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            int compare = compareStrings(original, substring, result[mid]);
            if (compare == 0) {
                return result[mid];
            }
            if (compare == -1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SuffixArray suffix = new SuffixArray();
        char[] original = "mississippi".toCharArray();

        Integer[] result = suffix.constructSuffixArray(original);
        //suffix.printSortedSuffixes(result, original);
        int beginIndex = suffix.findMatchingSubstring(original, "ssipp".toCharArray(), result);
        if (beginIndex == -1) {
            System.out.println("substring not found");
        } else {
            System.out.println("Substring found at index " + beginIndex);
        }
    }
}
