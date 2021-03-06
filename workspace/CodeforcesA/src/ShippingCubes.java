public class ShippingCubes
{
	public boolean isPrime(long n) {
		if(n == 1) return false;
		if(n == 2) return true;
		if(n % 2 == 0) return false;
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return n > 1;
	}
	
	long dp[][] = new long[100][100];

	long nCr(int n, int r) {
		if (n == r)
			return dp[n][r] = 1;
		if (r == 0)
			return dp[n][r] = 1;
		if (r == 1)
			return dp[n][r] = (long) n;
		if (dp[n][r] > 0)
			return dp[n][r];
		return dp[n][r] = nCr(n - 1, r) + nCr(n - 1, r - 1);
	}
	
	public int minimalCost(int N)
	{		
		long k = nCr(10, 5);
		System.out.println(k);
		return 0;
	}
	
	public int editDistance(String s1, String s2) {
		int[][] DP = new int[101][101];
		for (int i = 0; i <= s1.length(); i++)
			DP[i][0] = i;
		for (int i = 0; i <= s2.length(); i++)
			DP[0][i] = i;
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				int val = s1.charAt(i) == s2.charAt(j) ? 0 : 1;
				DP[i + 1][j + 1] = Math.min(DP[i][j] + val,
						Math.min(DP[i][j + 1] + 1, DP[i + 1][j] + 1));
			}
		}
		return DP[s1.length()][s2.length()];
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + p0);
		System.out.println("]");
		ShippingCubes obj;
		int answer;
		obj = new ShippingCubes();
		long startTime = System.currentTimeMillis();
		answer = obj.minimalCost(p0);
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
		all_right = true;
		
		int p0;
		int p1;
		
		// ----- test 0 -----
		p0 = 1;
		p1 = 3;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 6;
		p1 = 6;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 7;
		p1 = 9;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 200;
		p1 = 18;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
