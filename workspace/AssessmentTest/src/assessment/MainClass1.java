package assessment;

//Given an array of integers, return True if there are 3 numbers in the array that sum 0. False otherwise.
//[10, 5, -2, 7, -3] -> True
//[10, 4, -2, 7, -3] -> False 

//[ -3, -2, 5, 7, 10]  
// i,            j

import java.util.*;

public class MainClass1 {

	public boolean findTwoElementsSum(int thirdElement, int ind, int[] arr) {
		boolean res = false;
		int i = 0, j = arr.length - 1;

		while (i < j) {
			int sum = arr[i] + arr[j];
			if (sum * -1 == thirdElement && ind != i && ind != j) {
				res = true;
				break;
			} else if (sum * -1 < thirdElement) {
				j--;
			} else {
				i++;
			}
		}
		return res;
	}

	public boolean threeElementsSumZeroNew(int[] arr) {
		Arrays.sort(arr);
		boolean ans = false;
		for (int i = 0; i < arr.length; i++) {
			ans = ans || findTwoElementsSum(arr[i], i, arr);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		//int[] arr = {10, 5, -2, 7, -3};
		int[] arr = {10, 4, -2, 7, -3};
		boolean ok = new MainClass1().threeElementsSumZeroNew(arr);
		System.out.println(ok);
	}
}