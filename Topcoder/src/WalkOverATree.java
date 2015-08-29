import java.util.*;

public class WalkOverATree {
    private int ans;
    private int L;

    private Map<Integer, List<Integer>> graphList = new HashMap<>();
    private Map<Integer, Integer> visitedCount = new HashMap<>();

    private int[][] dp = new int[51][101];

    private void recurse(int nodeId, int count, int steps) {
        if (steps >= L) {
            ans = Math.max(ans, count);
            return;
        }
        int k = visitedCount.get(nodeId);
        visitedCount.put(nodeId, k + 1);
        List<Integer> neighboursList = graphList.get(nodeId);
        for (int i = 0; i < neighboursList.size(); i++) {
            int neighbour = neighboursList.get(i);
            if (visitedCount.get(neighbour) > 0) {
                recurse(neighbour, count, steps + 1);
            } else {
                recurse(neighbour, count + 1, steps + 1);
            }
        }
        visitedCount.put(nodeId, k);
    }

    public int maxNodesVisited(int[] parent, int L) {
        this.ans = 0;
        this.L = L;

        //init DP array
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[i].length; j++)
                dp[i][j] = -1;

        //constructing the graph
        for (int i = 0; i <= parent.length; i++) {
            graphList.put(i, new ArrayList<>());
        }
        for (int i = 0; i < parent.length; i++) {
            graphList.get(parent[i]).add(i + 1);
            graphList.get(i + 1).add(parent[i]);
        }
        //System.out.println(graphList);
        //visited count shows how many times the node is visited.
        for (int i = 0; i <= parent.length; i++) {
            visitedCount.put(i, 0);
        }

        recurse(0, 1, 0);
        return ans;
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit-pf 2.3.0
    private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int p1, boolean hasAnswer, int p2) {
        System.out.print("Test " + testNum + ": [" + "{");
        for (int i = 0; p0.length > i; ++i) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(p0[i]);
        }
        System.out.print("}" + "," + p1);
        System.out.println("]");
        WalkOverATree obj;
        int answer;
        obj = new WalkOverATree();
        long startTime = System.currentTimeMillis();
        answer = obj.maxNodesVisited(p0, p1);
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
        int p1;
        int p2;

        // ----- test 0 -----
        disabled = false;
        p0 = new int[]{0, 0};
        p1 = 2;
        p2 = 2;
        all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 1 -----
        disabled = false;
        p0 = new int[]{0, 0};
        p1 = 3;
        p2 = 3;
        all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 2 -----
        disabled = false;
        p0 = new int[]{0, 1, 2, 3};
        p1 = 2;
        p2 = 3;
        all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 3 -----
        disabled = false;
        p0 = new int[]{0, 0, 0, 0, 2, 4, 2, 3, 1};
        p1 = 1;
        p2 = 2;
        all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 4 -----
        disabled = false;
        p0 = new int[]{0, 0, 1, 2, 3, 2, 3, 1, 3, 0, 1, 8, 6, 8, 0, 5, 15, 0, 9};
        p1 = 4;
        p2 = 5;
        all_right = (disabled || KawigiEdit_RunTest(4, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 5 -----
        /*disabled = false;
        p0 = new int[]{0, 0, 0, 1, 1, 3, 5, 1, 4, 5, 2, 2, 10, 5, 10, 10, 11, 13, 8, 3, 18, 15, 20, 20, 23, 8, 11, 26, 4};
        p1 = 26;
        p2 = 17;
        all_right = (disabled || KawigiEdit_RunTest(5, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled; */
        // ------------------

        // ----- test 6 -----
        disabled = false;
        p0 = new int[]{0, 0, 2, 0};
        p1 = 100;
        p2 = 5;
        all_right = (disabled || KawigiEdit_RunTest(6, p0, p1, true, p2)) && all_right;
        tests_disabled = tests_disabled || disabled;
        // ------------------

        // ----- test 7 -----
        disabled = false;
        p0 = new int[]{0, 0, 2};
        p1 = 4;
        p2 = 4;
        all_right = (disabled || KawigiEdit_RunTest(7, p0, p1, true, p2)) && all_right;
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
