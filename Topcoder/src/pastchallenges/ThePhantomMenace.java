package pastchallenges;

public class ThePhantomMenace {
    public int find(int[] doors, int[] droids) {
        int ans = 0;
        //int[] arr = new int[doors.length];
        for (int i = 0; i < doors.length; i++) {
            int distance = Integer.MAX_VALUE;
            for (int item : droids) {
                distance = Math.min(distance, Math.abs(doors[i] - item));
            }
            ans = Math.max(ans, distance);
        }
        return ans;
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit-pf 2.3.0
    private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, boolean hasAnswer, int p2) {
        System.out.print("Test " + testNum + ": [" + "{");
        for (int i = 0; p0.length > i; ++i) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(p0[i]);
        }
        System.out.print("}" + "," + "{");
        for (int i = 0; p1.length > i; ++i) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(p1[i]);
        }
        System.out.print("}");
        System.out.println("]");
        ThePhantomMenace obj;
        int answer;
        obj = new ThePhantomMenace();
        long startTime = System.currentTimeMillis();
        answer = obj.find(p0, p1);
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

        int[] p0;
        int[] p1;
        int p2;

        // ----- test 0 -----
        disabled = false;
        p0 = new int[]{1, 2, 3, 4};
        p1 = new int[]{5, 6, 7, 8};
        p2 = 4;
        all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 1 -----
        disabled = false;
        p0 = new int[]{1};
        p1 = new int[]{10};
        p2 = 9;
        all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 2 -----
        disabled = false;
        p0 = new int[]{2, 3, 5, 7, 11};
        p1 = new int[]{1, 8, 13};
        p2 = 3;
        all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 3 -----
        disabled = false;
        p0 = new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        p1 = new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        p2 = 1;
        all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 4 -----
        disabled = false;
        p0 = new int[]{2, 1};
        p1 = new int[]{4, 3};
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