package pastchallenges;

public class UndoHistory {
    public int minPresses(String[] lines) {
        int ans = lines[0].length() + 1;
        for (int i = 1; i < lines.length; i++) {
            int fromPrev = getFromPrevious(lines[i - 1], lines[i]);
            int fromHistory = getFromHistory(i, lines);
            ans = Math.min(fromPrev, fromHistory) + ans;
        }
        return ans;
    }

    private int getFromPrevious(String prev, String now) {
        if (now.startsWith(prev)) return 1 + now.length() - prev.length();
        return Integer.MAX_VALUE;
    }

    private int getFromHistory(int index, String[] lines) {
        String now = lines[index];
        int res = now.length() + 100;
        for (int i = 0; i < index; i++) {
            int prefixCommon = getCommonPrefix(now, lines[i]);
            res = Math.min(res, now.length() - prefixCommon + 3);
        }
        return res;
    }

    private int getCommonPrefix(String now, String prev) {
        int i = 0, j = 0;
        while (i < now.length() && j < prev.length()) {
            if (now.charAt(i) == prev.charAt(j)) {
                i++;
                j++;
            } else {
                break;
            }
        }
        return i;
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit-pf 2.3.0
    private static boolean KawigiEdit_RunTest(int testNum, String[] p0, boolean hasAnswer, int p1) {
        System.out.print("Test " + testNum + ": [" + "{");
        for (int i = 0; p0.length > i; ++i) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print("\"" + p0[i] + "\"");
        }
        System.out.print("}");
        System.out.println("]");
        UndoHistory obj;
        int answer;
        obj = new UndoHistory();
        long startTime = System.currentTimeMillis();
        answer = obj.minPresses(p0);
        long endTime = System.currentTimeMillis();
        boolean res;
        res = true;
        System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
        if (hasAnswer) {
            System.out.println("Desired answer:");
            System.out.println("\t" + p1);
        }
        System.out.println("Your answer:");
        System.out.println("\t" + answer);
        if (hasAnswer) {
            res = answer == p1;
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

        String[] p0;
        int p1;

        // ----- test 0 -----
        disabled = false;
        p0 = new String[]{"tomorrow", "topcoder"};
        p1 = 18;
        all_right = (disabled || KawigiEdit_RunTest(0, p0, true, p1)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 1 -----
        disabled = false;
        p0 = new String[]{"a", "b"};
        p1 = 6;
        all_right = (disabled || KawigiEdit_RunTest(1, p0, true, p1)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 2 -----
        disabled = false;
        p0 = new String[]{"a", "ab", "abac", "abacus"};
        p1 = 10;
        all_right = (disabled || KawigiEdit_RunTest(2, p0, true, p1)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 3 -----
        disabled = false;
        p0 = new String[]{"pyramid", "sphinx", "sphere", "python", "serpent"};
        p1 = 39;
        all_right = (disabled || KawigiEdit_RunTest(3, p0, true, p1)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 4 -----
        disabled = false;
        p0 = new String[]{"ba", "a", "a", "b", "ba"};
        p1 = 13;
        all_right = (disabled || KawigiEdit_RunTest(4, p0, true, p1)) && all_right;
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
