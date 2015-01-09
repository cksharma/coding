package medium;

public class FindPeakElement {
	
	private int recurse(int[] num, int start, int end) {
		int middle = (start + end) / 2;
		if (middle - 1 >= 0 && middle + 1 < num.length && num[middle] > num[middle -1] && num[middle] > num[middle + 1]) {
			return middle;
		} else if (end - start <= 1) {
			if (num[end] > num[start]) return end;
			else return start;
		} else if (num[middle] <= num[middle - 1]) {
			return recurse(num, start, middle - 1);
		} else {
			return recurse(num, middle + 1, end);
		}
	}
	
    public int findPeakElement(int[] num) {
        return recurse(num, 0, num.length - 1);
    }
    public static void main(String[] args) {
		FindPeakElement sol = new FindPeakElement();
		System.out.println(sol.findPeakElement(new int[] {1, 2, 3, 1}));
		System.out.println(sol.findPeakElement(new int[] {1, 2, 2}));
	}
}
