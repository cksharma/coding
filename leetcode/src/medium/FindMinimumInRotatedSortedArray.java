package medium;

public class FindMinimumInRotatedSortedArray {
    
	private int binarySearch(int ans, int left, int right, int[] num) {
		if (left <= right) {
			int middle = (left + right) / 2;
			ans = Math.min(ans, num[middle]);
			if (middle - 1 >= 0) {
				ans = Math.min(ans, num[middle - 1]);
			}
			if (middle + 1 < num.length) {
				ans = Math.min(ans, num[middle + 1]);
			}
			if (num[middle] < num[left]) {
				return binarySearch(ans, left, middle - 1, num);
			} else {
				return binarySearch(ans, middle + 1, right, num);
			}
		}
		return ans;
	}
	
	public int findMin(int[] num) {
        int ans = num[0];
        int left = 0;
        int right = num.length - 1;
        return binarySearch(ans, left, right, num);
    }
    
	public static void main(String[] args) {
		FindMinimumInRotatedSortedArray sol = new FindMinimumInRotatedSortedArray();
		int[] num = {4, 5, 6, 7, 11, 0, 1, 2, 3};
		//num = new int[] {1,2};
		//num = new int[] {1};
		//num = new int[] {3, 4, 5, 6, 7, 8, -2, -1, 0, 1, 2};
		//num = new int[] {3,1,2};
		//num = new int[] {2, 1};
		System.out.println(sol.findMin(num));
	}
}
