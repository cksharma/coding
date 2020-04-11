package pastchallenges;

import java.util.Arrays;

public class TheKingsFactorization_Petr {

	public long[] getVector(long N, long[] primes) {
		for (long x : primes)
			N /= x;
		long[] res = new long[2 * primes.length - 1];
		for (int i = 0; i < primes.length - 1; ++i) {
			res[i * 2] = primes[i];
			if (N <= primes[i + 1]) {
				res[i * 2 + 1] = N;
				N = 1;
			} else {
				for (long u = primes[i]; u <= primes[i + 1]; ++u)
					if (N % u == 0) {
						N /= u;
						res[i * 2 + 1] = u;
						break;
					}
			}
		}
		res[res.length - 1] = primes[primes.length - 1];
		if (N > 1) {
			res = Arrays.copyOf(res, res.length + 1);
			res[res.length - 1] = N;
		}
		return res;
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, long p0, long[] p1, boolean hasAnswer, long[] p2) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + "{");
		for (int i = 0; p1.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p1[i]);
		}
		System.out.print("}");
		System.out.println("]");
		TheKingsFactorization_Petr obj;
		long[] answer;
		obj = new TheKingsFactorization_Petr();
		long startTime = System.currentTimeMillis();
		answer = obj.getVector(p0, p1);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.print("\t" + "{");
			for (int i = 0; p2.length > i; ++i) {
				if (i > 0) {
					System.out.print(",");
				}
				System.out.print(p2[i]);
			}
			System.out.println("}");
		}
		System.out.println("Your answer:");
		System.out.print("\t" + "{");
		for (int i = 0; answer.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(answer[i]);
		}
		System.out.println("}");
		if (hasAnswer) {
			if (answer.length != p2.length) {
				res = false;
			} else {
				for (int i = 0; answer.length > i; ++i) {
					if (answer[i] != p2[i]) {
						res = false;
					}
				}
			}
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

		long p0;
		long[] p1;
		long[] p2;

		// ----- test 0 -----
		disabled = false;
		p0 = 12L;
		p1 = new long[] { 2L, 3L };
		p2 = new long[] { 2L, 2L, 3L };
		all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, true, p2)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 1 -----
		disabled = false;
		p0 = 7L;
		p1 = new long[] { 7L };
		p2 = new long[] { 7L };
		all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, true, p2)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 2 -----
		disabled = false;
		p0 = 1764L;
		p1 = new long[] { 2L, 3L, 7L };
		p2 = new long[] { 2L, 2L, 3L, 3L, 7L, 7L };
		all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, true, p2)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 3 -----
		disabled = false;
		p0 = 49L;
		p1 = new long[] { 7L };
		p2 = new long[] { 7L, 7L };
		all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, true, p2)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 4 -----
		disabled = false;
		p0 = 210L;
		p1 = new long[] { 2L, 5L };
		p2 = new long[] { 2L, 3L, 5L, 7L };
		all_right = (disabled || KawigiEdit_RunTest(4, p0, p1, true, p2)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 5 -----
		disabled = false;
		p0 = 100000L;
		p1 = new long[] { 2L, 2L, 2L, 5L, 5L };
		p2 = new long[] { 2L, 2L, 2L, 2L, 2L, 5L, 5L, 5L, 5L, 5L };
		all_right = (disabled || KawigiEdit_RunTest(5, p0, p1, true, p2)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 5 -----
		disabled = false;
		p0 = 444279237316L;
		p1 = new long[] { 2, 111069809329L };
		p2 = new long[] { 2, 2, 111069809329L };
		all_right = (disabled || KawigiEdit_RunTest(5, p0, p1, true, p2)) && all_right;
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
