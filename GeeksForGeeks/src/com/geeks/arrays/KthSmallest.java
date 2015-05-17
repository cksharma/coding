package com.geeks.arrays;

public class KthSmallest
{
	public static int findKthSmallest(int[] A, int p, int r, int i)
	{
		if (p == r) return A[p];
		int q = partition(A, p, r);
		int k = q - p + 1;
		if (i == k) return A[i];
		else if (i < k) return findKthSmallest(A, p, r - 1, i);
		else return findKthSmallest(A, q + 1, r, i - k);
	}

	public static int partition(int arr[], int left, int right)
	{
		int i = left, j = right;
		int tmp;
		int pivot = arr[(left + right) / 2];

		while (i <= j)
		{
			while (arr[i] < pivot)
				i++;
			while (arr[j] > pivot)
				j--;
			if (i <= j)
			{
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		;

		return i;
	}

	public static void main(String[] args)
	{
		int[] A = new int[] { 1, 4, 7, 2, 5, 6, 9, 8 };
		int ans = findKthSmallest(A, 0, A.length - 1, 0);
		System.out.println(ans);
	}
}
