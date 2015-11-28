package medium;

public class JumpGame {
	public boolean canJump(int[] A) {
		if (A == null || A.length == 0) return true;
		int lastPoint = 0, start = 0;
		while (lastPoint < A.length && start < A.length && lastPoint >= start) {
			lastPoint = Math.max(lastPoint, A[start] + start);
			start++;
		}
		return lastPoint >= A.length - 1;
	}

	@Override
	public void finalize() {

	}

	public static void main(String[] args) {
		JumpGame sol = new JumpGame();
		System.out.println(sol.canJump(new int[] { 2, 3, 1, 1, 4 }));
		System.out.println(sol.canJump(new int[] { 3, 2, 1, 0, 4 }));
	}
}
