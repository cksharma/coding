package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumII {
    	
    public List<List<Integer>> combinationSum2(int[] num, int target) {
    	this.ans = new ArrayList<>();
        this.target = target;
        Arrays.sort(num);
        subsets_recurse(num, 0, new int[num.length], 0);
        Set <List <Integer>> set = new HashSet<>();
        for (List <Integer> list : ans) {
        	set.add(list);
        }
        List <List<Integer>> res = new ArrayList<>();
        for (List <Integer> list : set) {
        	res.add(list);
        }
		return res;
    }    
    
    private List <List <Integer>> ans;
    private int target;
    
	private void subsets_recurse(int[] S, int index, int[] arr, int runningSum) {
		
		arr[index] = 1;		
		if (runningSum + S[index] == target) {
			List <Integer> list = new ArrayList <>();
			for (int i = 0; i <= index; i++) {
				if (arr[i] != 0) 
					list.add(S[i]);
			}
			ans.add(list);
		}
		else if (index + 1 < S.length && runningSum + S[index] < target) {
			subsets_recurse(S, index + 1, arr, runningSum + S[index]);
		}
		if (index + 1 < S.length && runningSum + S[index + 1] <= target) {
			arr[index] = 0;
			subsets_recurse(S, index + 1, arr, runningSum);
		}
	}
 	
    public static void main(String[] args) {
		CombinationSumII sol = new CombinationSumII();
		System.out.println(sol.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
		
		sol = new CombinationSumII();
		System.out.println(sol.combinationSum2(new int[]{14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12}, 27));
	}
}
