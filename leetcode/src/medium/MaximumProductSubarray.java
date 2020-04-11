package medium;

public class MaximumProductSubarray {

	public int maxProduct(int[] A) {
		int forward = 1;
		int backward = 1;
		int ans = Integer.MIN_VALUE;

		for (int i = 0; i < A.length; i++) {
			forward = forward * A[i];
			backward = backward * A[A.length - 1 - i];
			ans = Math.max(ans, Math.max(forward, backward));
			forward = (forward == 0) ? 1 : forward;
			backward = (backward == 0) ? 1 : backward;
		}
		return ans;
	}

	public static void main(String[] args) {
		MaximumProductSubarray sol = new MaximumProductSubarray();
		int[] A = { 2, 3, -2, 4 };
		System.out.println(sol.maxProduct(A));
	}
}
