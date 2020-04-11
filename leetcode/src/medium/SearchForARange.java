package medium;

import java.util.Arrays;

public class SearchForARange {
    
	public int[] searchRange(int[] A, int target) {
		int first = binarySearchLeft(A, 0, A.length - 1, target);
		int secon = binarySearchRigh(A, 0, A.length - 1, target);
		return new int[] {first, secon};
    }
    
	private int binarySearchLeft(int[] A, int start, int end, int value) {
		if (start > end) return -1;
		int mid = (start + end) / 2;
		if (A[mid] == value && (mid == 0 || A[mid - 1] != value))
			return mid;
		if (A[mid] >= value) {
			return binarySearchLeft(A, start, mid - 1, value);
		} else {
			return binarySearchLeft(A, mid + 1, end, value);
		}
	}
	
	private int binarySearchRigh(int[] A, int start, int end, int value) {
		if (start > end) return -1;
		int mid = (start + end) / 2;
		if (A[mid] == value && (mid == A.length - 1 || A[mid + 1] != value))
			return mid;
		if (A[mid] > value) {
			return binarySearchRigh(A, start, mid - 1, value);
		} else {
			return binarySearchRigh(A, mid + 1, end, value);
		}
	}
	
	public static void main(String[] args) {		
		SearchForARange sol = new SearchForARange();
		System.out.println(Arrays.toString(sol.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 5)));
	}
}
