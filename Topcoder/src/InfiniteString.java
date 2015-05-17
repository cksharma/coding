
public class InfiniteString {

    public long LCM(long a, long b) {
        if (a < 0)
            return LCM(-a, b);
        if (b < 0)
            return LCM(a, -b);
        return a * (b / GCD(a, b));
    }

    public long GCD(long a, long b) {
        if (a < 0) return GCD(-a, b);
        if (b < 0) return GCD(a, -b);
        return b == 0 ? a : GCD(b, a % b);
    }

    public String equal(String s, String t) {
        String ans = "Not equal";
        long lcm = LCM(s.length(), t.length());
        String s1 = s, t1 = t;
        while (s1.length() < lcm) {
            s1 += s;
        }
        while (t1.length() < lcm) {
            t1 += t;
        }
        return s1.equals(t1) ? "Equal" : ans;
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit-pf 2.3.0
    private static boolean KawigiEdit_RunTest(int testNum, String p0, String p1, boolean hasAnswer, String p2) {
        System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"" + "," + "\"" + p1 + "\"");
        System.out.println("]");
        InfiniteString obj;
        String answer;
        obj = new InfiniteString();
        long startTime = System.currentTimeMillis();
        answer = obj.equal(p0, p1);
        long endTime = System.currentTimeMillis();
        boolean res;
        res = true;
        System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
        if (hasAnswer) {
            System.out.println("Desired answer:");
            System.out.println("\t" + "\"" + p2 + "\"");
        }
        System.out.println("Your answer:");
        System.out.println("\t" + "\"" + answer + "\"");
        if (hasAnswer) {
            res = answer.equals(p2);
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

        String p0;
        String p1;
        String p2;

        // ----- test 0 -----
        disabled = false;
        p0 = "ab";
        p1 = "abab";
        p2 = "Equal";
        all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 1 -----
        disabled = false;
        p0 = "abc";
        p1 = "bca";
        p2 = "Not equal";
        all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 2 -----
        disabled = false;
        p0 = "abab";
        p1 = "aba";
        p2 = "Not equal";
        all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 3 -----
        disabled = false;
        p0 = "aaaaa";
        p1 = "aaaaaa";
        p2 = "Equal";
        all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 4 -----
        disabled = false;
        p0 = "ababab";
        p1 = "abab";
        p2 = "Equal";
        all_right = (disabled || KawigiEdit_RunTest(4, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 5 -----
        disabled = false;
        p0 = "a";
        p1 = "z";
        p2 = "Not equal";
        all_right = (disabled || KawigiEdit_RunTest(5, p0, p1, true, p2)) && all_right;
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