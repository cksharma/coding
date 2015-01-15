package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.ans = new ArrayList<>();
        this.target = target;
        Arrays.sort(candidates);
        int min = Arrays.stream(candidates).min().getAsInt();
        int[] arr = new int[target / min * target + 1];
        subsets_recurse(candidates, 0, arr, 0);
        Set <List <Integer> > st = new HashSet <>();
        List <List <Integer>> res = new ArrayList<>();
        for (List <Integer> item : ans) {
        	if (st.contains(item)) continue;
        	st.add(item);
        	res.add(item);
        }
		return res;
    }
    
    private List<List<Integer>> ans;
	private int target;
	private int start;
	
 	private void subsets_recurse(int[] S, int index, int[] arr, int sum) {
		for (int i = start; i < S.length; i++) {
			if (sum + S[i] == target) {
				arr[index++] = S[i];
				List <Integer> list = new ArrayList <>();
				for (int k = 0; k < index; k++) {
					if (arr[k] != 0) {
						list.add(arr[k]);
					}
				}
				Collections.sort(list);
				ans.add(list);
			}

			if (sum + S[i] > target) { 
				//start = start + 1;
				return;
			}	
						
			arr[index] = S[i];
			subsets_recurse(S, index + 1, arr, sum + S[i]);
		}
	}
	
	public static void main(String[] args) {
		CombinationSum sol = new CombinationSum();
		System.out.println(sol.combinationSum(new int[]{2,3,6,7, 8, 9}, 7));
		
		sol = new CombinationSum();
		System.out.println(sol.combinationSum(new int[]{1,2}, 4));
	}
}
