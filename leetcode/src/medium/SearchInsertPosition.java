package medium;

public class SearchInsertPosition {
    
	public int searchInsert(int[] A, int target) {
		return binarySearch(A, 0, A.length - 1, target);
    }
	
	private int binarySearch(int[] A, int start, int end, int target) {
		if (start > end) return -1;
		int mid = (start + end) / 2;
		if (A[mid] == target) return mid;
		if (A[mid] < target && mid + 1 < A.length && A[mid + 1] > target) return mid + 1;
		if (A[mid] > target && mid - 1 >= 0 && A[mid - 1] < target) return mid;
		if (mid == 0 && A[mid] > target) return 0;
		if (mid == A.length - 1 && A[mid] < target) return A.length;
		if (A[mid] > target)
			return binarySearch(A, start, mid - 1, target);
		else
			return binarySearch(A, mid + 1, end, target);
	}
	
    public static void main(String[] args) {
		SearchInsertPosition sol = new SearchInsertPosition();
		System.out.println(sol.searchInsert(new int[]{1,3,5,6}, 5));
		System.out.println(sol.searchInsert(new int[]{1,3,5,6}, 2));
		System.out.println(sol.searchInsert(new int[]{1,3,5,6}, 7));
		System.out.println(sol.searchInsert(new int[]{1,3,5,6}, 0));
	}
}
