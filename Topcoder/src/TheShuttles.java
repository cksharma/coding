import java.util.Arrays;


public class TheShuttles {
	public int getLeastCost(int[] cnt, int baseCost, int seatCost) {
		int ans = Integer.MAX_VALUE;
		int max = Arrays.stream(cnt).max().getAsInt();
		for (int X = 1; X <= max; X++) {
			int cost = 0;			
			for (int i = 0; i < cnt.length; i++) {
				int mycost = baseCost + X * seatCost;				
				mycost *= Math.ceil(cnt[i] * 1. / X);
				cost += mycost;
			}
			
			if (cost < ans) {
				ans = cost;
			}
		}
		return ans;	
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int p1, int p2, boolean hasAnswer, int p3) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}" + "," + p1 + "," + p2);
		System.out.println("]");
		TheShuttles obj;
		int answer;
		obj = new TheShuttles();
		long startTime = System.currentTimeMillis();
		answer = obj.getLeastCost(p0, p1, p2);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p3);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p3;
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
		int p3;

		// ----- test 0 -----
		disabled = false;
		p0 = new int[] { 9 };
		p1 = 30;
		p2 = 5;
		p3 = 75;
		all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, p2, true, p3)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 1 -----
		disabled = false;
		p0 = new int[] { 9, 4 };
		p1 = 30;
		p2 = 5;
		p3 = 150;
		all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, p2, true, p3)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 2 -----
		disabled = false;
		p0 = new int[] { 9, 4 };
		p1 = 10;
		p2 = 5;
		p3 = 105;
		all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, p2, true, p3)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 3 -----
		disabled = false;
		p0 = new int[] { 51, 1, 77, 14, 17, 10, 80 };
		p1 = 32;
		p2 = 40;
		p3 = 12096;
		all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, p2, true, p3)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 3 -----
		disabled = false;
		p0 = new int[] { 5, 6};
		p1 = 1;
		p2 = 100;
		p3 = 1111;
		all_right = (disabled || KawigiEdit_RunTest(4, p0, p1, p2, true, p3)) && all_right;
		tests_disabled = tests_disabled || disabled;
		
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

// Powered by KawigiEdit-pf 2.3.0!
