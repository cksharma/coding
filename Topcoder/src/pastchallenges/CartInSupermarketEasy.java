package pastchallenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartInSupermarketEasy {
	public int calc(int N, int K) {
		int ans = N;
		List <Integer> list = new ArrayList <>();
		list.add(N);
		
		int steps = 0;
		
		while (steps != K) {
			ans = Math.min(ans, steps + maxElement(list));
			Collections.sort(list);
			Collections.reverse(list);
			
			List <Integer> temp = new ArrayList <>();
			
			int index = 0;
			boolean done = false;
			for (int item : list) {
				done = false;
				List <Integer> kk = new ArrayList <>();
				for (int r : list) {
					kk.add(r - 1);
				}
				ans = Math.min(ans, (steps + 1) + maxElement(kk));
				temp.add((item + 1) / 2);
				temp.add(item / 2);
					
				steps++;
				index++;
				
				List <Integer> cks = new ArrayList <>();
				for (int ck : temp) cks.add(ck);
				for (int i = index; i < list.size(); i++) {
					cks.add(list.get(i) - 1);
				}				
				ans = Math.min(ans, steps + maxElement(cks));
				
//				kk = new ArrayList <>();
//				for (int r : cks) {
//					if (r <= 3)
//						kk.add(r - 1);
//				}
				
				int before = ans;
				ans = Math.min(ans, (steps) + maxElement(cks));
				
				if (ans != before) {
					//list = cks;
					done = true;
				}
				if (steps == K) break;
			}
			if (!done)
				list = temp;
		}
		
		return Math.min(ans, steps + maxElement(list));
	}
	
	private int maxElement(List <Integer> set) {
		int ans = 0;
		for (int item : set) {
			ans = Math.max(ans, item);
		}
		return ans;
	}

	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit-pf 2.3.0
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1);
		System.out.println("]");
		CartInSupermarketEasy obj;
		int answer;
		obj = new CartInSupermarketEasy();
		long startTime = System.currentTimeMillis();
		answer = obj.calc(p0, p1);
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
		p0 = 5;
		p1 = 0;
		p2 = 5;
		all_right = (disabled || KawigiEdit_RunTest(0, p0, p1, true, p2)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 1 -----
		disabled = false;
		p0 = 5;
		p1 = 2;
		p2 = 4;
		all_right = (disabled || KawigiEdit_RunTest(1, p0, p1, true, p2)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 2 -----
		disabled = false;
		p0 = 15;
		p1 = 4;
		p2 = 6;
		all_right = (disabled || KawigiEdit_RunTest(2, p0, p1, true, p2)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 3 -----
		disabled = false;
		p0 = 7;
		p1 = 100;
		p2 = 4;
		all_right = (disabled || KawigiEdit_RunTest(3, p0, p1, true, p2)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 4 -----
		disabled = false;
		p0 = 45;
		p1 = 5;
		p2 = 11;
		all_right = (disabled || KawigiEdit_RunTest(4, p0, p1, true, p2)) && all_right;
		tests_disabled = tests_disabled || disabled;
		// ------------------

		// ----- test 5 -----
		disabled = false;
		p0 = 100;
		p1 = 100;
		p2 = 8;
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

// Powered by KawigiEdit-pf 2.3.0!
