package com.geeks.zdummy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Chandra Kant on 3/23/2015.
 */
public class ArraySize {
    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);
        int num = ss.nextInt();
        boolean ans = is_3d_array_size(num);
        System.out.println(ans);
    }
    static boolean is_3d_array_size(int a_size) {
        List<Integer> primeFactors = getPrimeFactors(a_size);
        return a_size >= 8 && primeFactors.size() > 2;
    }

    private static List <Integer> getPrimeFactors(int num) {
        List <Integer> ans = new ArrayList<>();
        for (int i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                ans.add(i);
                num /= i;
            }
        }
        return ans;
    }
}
