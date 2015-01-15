package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    	
    public List<List<Integer>> combinationSum2(int[] num, int target) {
    	this.ans = new ArrayList<>();
        this.target = target;
        Arrays.sort(num);
        subsets_recurse(num, 0, new ArrayList<>(), 0);
		return ans;
    }    
    private List <List <Integer>> ans;
    private int target;
    
	@SuppressWarnings("unchecked")
	private void subsets_recurse(int[] S, int index, ArrayList<Integer> list, int runningSum) {
		if (index == S.length) return;
		if (runningSum == target) {
			ans.add((List<Integer>) list.clone());
			return;
		}
		if (runningSum < target) {
			list.add(S[index]);
			subsets_recurse(S, index + 1, list, runningSum + S[index]);
			list.remove(list.size() - 1);
			subsets_recurse(S, index + 1, list, runningSum - S[index]);
		}	
	}
 	
    public static void main(String[] args) {
		CombinationSumII sol = new CombinationSumII();
		System.out.println(sol.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
		
		sol = new CombinationSumII();
		System.out.println(sol.combinationSum2(new int[]{14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12}, 27));
	}
}
