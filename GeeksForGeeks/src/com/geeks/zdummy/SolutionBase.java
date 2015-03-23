package com.geeks.zdummy;

import java.util.Scanner;

public class SolutionBase {

    private static boolean checkNumberValidity(int base, String number) {
        try {
            Long.parseLong(number, base);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);
        int base = ss.nextInt();
        String number = ss.next();

        if (base < 2 || base > 36) {
            System.out.println("base invalid");
            System.exit(0);
        }
        boolean isValidNumber = checkNumberValidity(base, number);
        if (isValidNumber == false) {
            System.out.println("number invalid");
            System.exit(0);
        }
        long ans = Long.parseLong(number, base);
        System.out.println(ans);
    }
}
