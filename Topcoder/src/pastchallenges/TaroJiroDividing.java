package pastchallenges;

import java.util.HashSet;
import java.util.Set;


public class TaroJiroDividing {
	public int getNumber(int A, int B) {
		int ans = 0;
		Set <Integer> set = new HashSet <>();
		while (A > 1 && A % 2 == 0) {
			set.add(A);
			A /= 2;
		}
		set.add(A);
		while (B > 1 && B % 2 == 0) {
			if (set.contains(B)) ans++;
			B /= 2;
		}
		if (set.contains(B)) ans++;
		return ans;
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1);
		System.out.println("]");
		TaroJiroDividing obj;
		int answer;
		obj = new TaroJiroDividing();
		long startTime = System.currentTimeMillis();
		answer = obj.getNumber(p0, p1);
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
		p0 = 8;
		p1 = 4;
		p2 = 3;
		all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, true, p2)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 1 -----
		disabled = false;
		p0 = 4;
		p1 = 7;
		p2 = 0;
		all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, true, p2)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 2 -----
		disabled = false;
		p0 = 12;
		p1 = 12;
		p2 = 3;
		all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, true, p2)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 3 -----
		disabled = false;
		p0 = 24;
		p1 = 96;
		p2 = 4;
		all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, true, p2)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 4 -----
		disabled = false;
		p0 = 1000000000;
		p1 = 999999999;
		p2 = 0;
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

// Powered by KawigiEdit-pf 2.3.0!
