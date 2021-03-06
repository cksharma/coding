
public class ExplodingRobots {

    final static String EXPLOSION = "Explosion";
    final static String SAFE      = "Safe";

    public String canExplode(int x1, int y1, int x2, int y2, String instructions) {
        int dx1 = Math.abs(x2 - x1);
        int dy1 = Math.abs(y2 - y1);

        int east = 0, west = 0, north = 0, south = 0;
        for (int i = 0; i < instructions.length(); i++) {
            char ch = instructions.charAt(i);
            switch(ch) {
                case 'L': west++; break;
                case 'R': east++; break;
                case 'U': north++; break;
                case 'D': south++; break;
            }
        }
        if (west + east >= dx1 && north + south >= dy1) return EXPLOSION;
        return SAFE;
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit-pf 2.3.0
    private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, int p2, int p3, String p4, boolean hasAnswer, String p5) {
        System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + p2 + "," + p3 + "," + "\"" + p4 + "\"");
        System.out.println("]");
        ExplodingRobots obj;
        String answer;
        obj = new ExplodingRobots();
        long startTime = System.currentTimeMillis();
        answer = obj.canExplode(p0, p1, p2, p3, p4);
        long endTime = System.currentTimeMillis();
        boolean res;
        res = true;
        System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
        if (hasAnswer) {
            System.out.println("Desired answer:");
            System.out.println("\t" + "\"" + p5 + "\"");
        }
        System.out.println("Your answer:");
        System.out.println("\t" + "\"" + answer + "\"");
        if (hasAnswer) {
            res = answer.equals(p5);
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
        int p3;
        String p4;
        String p5;

        // ----- test 0 -----
        disabled = false;
        p0 = 1;
        p1 = 0;
        p2 = 2;
        p3 = 0;
        p4 = "L";
        p5 = "Explosion";
        all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, p2, p3, p4, true, p5)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 1 -----
        disabled = false;
        p0 = 1;
        p1 = 0;
        p2 = 2;
        p3 = 0;
        p4 = "U";
        p5 = "Safe";
        all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, p2, p3, p4, true, p5)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 2 -----
        disabled = false;
        p0 = 1;
        p1 = 0;
        p2 = 2;
        p3 = 0;
        p4 = "UL";
        p5 = "Explosion";
        all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, p2, p3, p4, true, p5)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 3 -----
        disabled = false;
        p0 = 3;
        p1 = 3;
        p2 = 5;
        p3 = 5;
        p4 = "LURLL";
        p5 = "Safe";
        all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, p2, p3, p4, true, p5)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 4 -----
        disabled = false;
        p0 = 10;
        p1 = 5;
        p2 = -9;
        p3 = -10;
        p4 = "LULULULLLUULRULULULULULULLULULLULD";
        p5 = "Explosion";
        all_right = (disabled || KawigiEdit_RunTest(4, p0, p1, p2, p3, p4, true, p5)) && all_right;
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
