package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    List <List <Integer>> ans;
	public List<List<Integer>> permute(int[] num) {
        this.ans = new ArrayList <>();
		Arrays.sort(num);
        do {
        	List <Integer> list = new ArrayList <>();
        	for (int item : num) list.add(item);
        	ans.add(list);
        } while (nextPermutation(num));
        return ans;
    }
	boolean nextPermutation(int[] a) {
		for (int i = a.length - 2; i >= 0; i--) {
			if (a[i] < a[i + 1]) {
				reverse(a, i + 1, a.length);
				for (int j = i + 1;; j++) {
					if (a[i] < a[j]) {
						swap(a, i, j);
						return true;
					}
				}
			}
		}
		return false;
	}

	void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	void reverse(int[] a, int b, int e) {
		while (b < e) {
			e--;
			swap(a, b, e);
			b++;
		}
	}
	public static void main(String[] args) {
		Permutations sol = new Permutations();
		System.out.println(sol.permute(new int[] {1, 2, 3}));
	}
}
