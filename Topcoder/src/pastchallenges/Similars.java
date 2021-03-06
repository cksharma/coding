package pastchallenges;

import java.util.ArrayList;
import java.util.Collections;

public class Similars {
    boolean nextPermutation(int[] a) {
        for (int i = a.length - 2; i >= 0; i--) {
            if (a[i] < a[i + 1]) {
                reverse(a, i + 1, a.length);
                for (int j = i + 1; ; j++) {
                    if (a[i] < a[j]) {
                        swap(a, i, j);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    void reverse(int[] a, int b, int e) {
        while (b < e) {
            e--;
            swap(a, b, e);
            b++;
        }
    }

    public int maxsim(int L, int R) {
        int ans = 0;
        for (int i = L; i <= R - 1; i++) {
            int left = i;

            int temp = i;
            ArrayList<Integer> list = new ArrayList<>();
            while (temp > 0) {
                list.add(temp % 10);
                temp /= 10;
            }
            Collections.sort(list);
            int[] arr = new int[list.size()];
            for (int r = 0; r < list.size(); r++) {
                arr[r] = list.get(r);
            }
            String firstString = i + "";
            if (ans >= arr.length) continue;
            do {
                int right = 0;
                int cnt = 0;
                for (int s = arr.length - 1; s >= 0; s--) {
                    right = right + arr[s] * (int) Math.pow(10, cnt++);
                }

                String seconString = right + "";
                if (right >= L && right <= R && i != right) {
                    ans = Math.max(ans, computeSimilarity(firstString, seconString));
                }
                ans = Math.max(ans, computeSimilarity(firstString, R + ""));
                ans = Math.max(ans, computeSimilarity(firstString, (i + 1) + ""));
            } while (nextPermutation(arr));
        }
        return ans;
    }

    private int computeSimilarity(String s1, String s2) {
        int ans = 0;
        for (char c = '0'; c <= '9'; c++) {
            if (s1.contains(c + "") && s2.contains(c + "")) ++ans;
        }
        return ans;
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit-pf 2.3.0
    private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, boolean hasAnswer, int p2) {
        System.out.print("Test " + testNum + ": [" + p0 + "," + p1);
        System.out.println("]");
        Similars obj;
        int answer;
        obj = new Similars();
        long startTime = System.currentTimeMillis();
        answer = obj.maxsim(p0, p1);
        long endTime = System.currentTimeMillis();
        boolean res;
        res = true;
        System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
        if (hasAnswer) {
            System.out.println("Desired answer:");
            System.out.println("\t" + p2);
        }
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        if (hasAnswer) {
            res = answer == p2;
        }
        if (!res) {
            System.out.println("DOESN'T MATCH!!!!");
        } else if ((endTime - startTime) / 1000.0 >= 2) {
            System.out.println("FAIL the timeout");
            res = false;
        } else if (hasAnswer) {
            System.out.println("Match :-)");
        } else {
            System.out.println("OK, but is it right?");
        }
        System.out.println("");
        return res;
    }

    public static void main(String[] args) {
        boolean all_right;
        boolean disabled;
        boolean tests_disabled;
        all_right = true;
        tests_disabled = false;

        int p0;
        int p1;
        int p2;

        // ----- test 0 -----
        disabled = false;
        p0 = 1;
        p1 = 10;
        p2 = 1;
        all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 1 -----
        disabled = false;
        p0 = 1;
        p1 = 99;
        p2 = 2;
        all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 2 -----
        disabled = false;
        p0 = 99;
        p1 = 100;
        p2 = 0;
        all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 3 -----
        disabled = false;
        p0 = 1000;
        p1 = 1010;
        p2 = 2;
        all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 4 -----
        disabled = false;
        p0 = 444;
        p1 = 454;
        p2 = 2;
        all_right = (disabled || KawigiEdit_RunTest(4, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        if (all_right) {
            if (tests_disabled) {
                System.out.println("You're a stud (but some test cases were disabled)!");
            } else {
                System.out.println("You're a stud (at least on given cases)!");
            }
        } else {
            System.out.println("Some of the test cases had errors.");
        }
    }
    // END KAWIGIEDIT TESTING
}

//Powered by KawigiEdit-pf 2.3.0!
