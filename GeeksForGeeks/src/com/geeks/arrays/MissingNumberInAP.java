package com.geeks.arrays;

/**
 * Created by cksharma on 4/10/15.
 */

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class MissingNumberInAP {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        SolutionAP solver = new SolutionAP();
        solver.solve(1, in, out);
        out.close();
    }
}

class SolutionAP {
    int[] arr;
    int gap;

    private int findMissingNumber(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            if (mid > 0 && arr[mid] - arr[mid - 1] != gap) {
                return arr[mid] - gap;
            }
            if (mid < arr.length - 1 && arr[mid + 1] - arr[mid] != gap) {
                return arr[mid] + gap;
            }
            int expected = arr[0] + gap * mid;
            if (arr[mid] == expected) {
                return findMissingNumber(mid + 1, high);
            } else {
                return findMissingNumber(low, mid - 1);
            }
        }
        return 0;
    }

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        this.arr =  new int[]{2, 4, 8, 10, 12, 14};
        this.arr = new int[] {1, 6, 11, 16, 21, 31};
        gap = Math.min(arr[1] - arr[0], arr[arr.length - 1] - arr[arr.length - 2]);
        int ans = findMissingNumber(0, arr.length);
        System.out.println(ans);

    }
}
