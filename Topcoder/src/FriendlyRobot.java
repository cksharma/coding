import java.util.HashMap;
import java.util.Map;

public class FriendlyRobot {

    public int findMaximumReturns(String instructions, int changesAllowed) {
        recurse(instructions, changesAllowed, 0);
        return res;
    }

    int res = 0;
    Map<String, Integer> cache = new HashMap<>();
    char[] arr = {'L', 'R', 'U', 'D'};

    private void recurse(String instructions, int changesAllowed, int index) {
        if (cache.containsKey(instructions)) {
            res = Math.max(res, cache.get(instructions));
            return;
        }

        int ans = solve(instructions);
        cache.put(instructions, ans);

        res = Math.max(res, ans);

        if (changesAllowed == 0 || index == instructions.length()) {
            return;
        }

        String before = instructions.substring(0, index);
        String after = instructions.substring(index + 1);

        for (char ch : arr) {
            String str = before + ch + after;
            recurse(str, changesAllowed - 1, index + 1);
            recurse(instructions, changesAllowed, index + 1);
        }

    }

    private int solve(String instructions) {
        int ans = 0;
        int x1 = 0, y1 = 0;
        for (int i = 0; i < instructions.length(); i++) {
            char ch = instructions.charAt(i);
            if (ch == 'L') x1--;
            else if (ch == 'R') x1++;
            else if (ch == 'U') y1--;
            else if (ch == 'D') y1++;
            if (x1 == 0 && y1 == 0) ans++;
        }
        return ans;
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit-pf 2.3.0
    private static boolean KawigiEdit_RunTest(int testNum, String p0, int p1, boolean hasAnswer, int p2) {
        System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"" + "," + p1);
        System.out.println("]");
        FriendlyRobot obj;
        int answer;
        obj = new FriendlyRobot();
        long startTime = System.currentTimeMillis();
        answer = obj.findMaximumReturns(p0, p1);
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

        String p0;
        int p1;
        int p2;

        // ----- test 0 -----
        disabled = false;
        p0 = "UULRRLLL";
        p1 = 1;
        p2 = 3;
        all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 1 -----
        disabled = false;
        p0 = "ULDR";
        p1 = 0;
        p2 = 1;
        all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 2 -----
        disabled = false;
        p0 = "ULDR";
        p1 = 2;
        p2 = 2;
        all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 3 -----
        disabled = false;
        p0 = "ULDRRLRUDUDLURLUDRUDL";
        p1 = 4;
        p2 = 8;
        all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 4 -----
        disabled = false;
        p0 = "LRLDRURDRDUDDDDRLLRUUDURURDRRDRULRDLLDDDDRLRRLLRRDDLRURLRULLLLLRRRDULRULULRLRDLLDDLLRDLUUDUURRULUDUDURULULLDRUDUUURRRURUULRLDLRRRDLLDLRDUULUURUDRURRLURLDLDDUUURRURRLRDLDDULLUDLUDULRDLDUURLUUUURRLRURRDLRRLLLRDRDUUUDRRRDLDRRUUDUDDUDDRLUDDULRURRDRUDLDLLLDLUDDRLURLDUDRUDDDDURLUUUDRLURDDDDLDDRDLUDDLDLURR";
        p1 = 47;
        p2 = 94;
        all_right = (disabled || KawigiEdit_RunTest(4, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 5 -----
        disabled = false;
        p0 = "UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU";
        p1 = 300;
        p2 = 150;
        all_right = (disabled || KawigiEdit_RunTest(5, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 6 -----
        disabled = false;
        p0 = "UD";
        p1 = 1;
        p2 = 1;
        all_right = (disabled || KawigiEdit_RunTest(6, p0, p1, true, p2)) && all_right;
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
