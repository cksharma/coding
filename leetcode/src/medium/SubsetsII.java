package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
	List <List<Integer>> ans;
    
	@SuppressWarnings("unchecked")
	private void recurse(int[] S, int index, ArrayList <Integer> list) {
		if (index == S.length) {
			ans.add((List<Integer>) list.clone());
			return;
		}
		list.add(S[index]);
		recurse(S, index + 1, list);
		list.remove(list.size() - 1);
		while (index + 1 < S.length && S[index] == S[index + 1]) index++;
		recurse(S, index + 1, list);
	}
	
	public List<List<Integer>> subsetsWithDup(int[] num) {
        this.ans = new ArrayList <>();
        Arrays.sort(num);
        recurse(num, 0, new ArrayList <Integer> ());
        return ans;
    }
	
	public static void main(String[] args) {
		SubsetsII sol = new SubsetsII();
		System.out.println(sol.subsetsWithDup(new int[] {4, 4, 1}));
	}
}
