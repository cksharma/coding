package medium;

import java.util.Arrays;

public class NextPermutation {
	public void nextPermutation(int[] num) {
		boolean hasnext = false;
		outer: for (int i = num.length - 1; i >= 1; i--) {
			if (num[i] > num[i - 1]) {				
				for (int j = num.length - 1; j >= i; j--) {
					if (num[i - 1] < num[j]) {
						swap(num, i - 1, j );
						reverse(num, i);
						hasnext = true;
						break outer;
					}					
				}
			}
		}
		if (!hasnext) {
			reverse(num, 0);
		}
    }	

	private void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}	
	private void reverse(int[] num, int start) {
		for (int i = 0; i < (num.length - start) / 2; i++) {
			swap(num, i + start, num.length - 1 - i);
		}
	}
	
	public static void main(String[] args) {
		NextPermutation sol = new NextPermutation();
		int[] num = new int[] {1, 2, 3};
		num = new int[] {1, 5, 4, 3, 2};
		num = new int[] {2, 1, 2};
		sol.nextPermutation(num);		
		//sol.reverse(num, 2);
		System.out.println(Arrays.toString(num));
		
	}
}
