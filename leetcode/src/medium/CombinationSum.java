package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(candidates);
		combinationSum(candidates, target, list, 0, new ArrayList<>(), 0);
		return list;
	}

	private void combinationSum(int[] candidates, int target, List<List<Integer>> list, int index, List<Integer> runningInts, int runningSum) {

		if (runningSum == target) {
			List<Integer> newList = new ArrayList<>(runningInts);
			list.add(newList);
			return;
		}
		if (index >= candidates.length || runningSum > target) return;

		runningInts.add(candidates[index]);
		combinationSum(candidates, target, list, index, runningInts, runningSum + candidates[index]);
		runningInts.remove(runningInts.size() -1 );
		combinationSum(candidates, target, list, index + 1, runningInts, runningSum);
	}
	
	public static void main(String[] args) {
		CombinationSum sol = new CombinationSum();
		System.out.println(sol.combinationSum(new int[]{2,3,6,7, 8, 9}, 7));
		
		sol = new CombinationSum();
		System.out.println(sol.combinationSum(new int[]{1,2}, 4));
	}
}
