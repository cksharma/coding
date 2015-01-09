package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    private List <List<Integer>> ans;
	
    public List<List<Integer>> subsets_costly(int[] S) {
        Arrays.sort(S); 
        int n = S.length;
		this.ans = new ArrayList <>();
		for (int i = 0; i < (1 << n); i++) {
			List <Integer> list = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				if (((1 << j) & i) != 0) {
					list.add(S[j]);
				}
			}
			ans.add(list);
		}
        return ans;
	}
	
	public List <List<Integer>> subsets(int[] S) {
		this.ans = new ArrayList<>();
		Arrays.sort(S);
		recurse(S, 0, new ArrayList <>());
		return ans;
	}
	
	@SuppressWarnings("unchecked")
	private void recurse(int[] S, int index, ArrayList <Integer> list) {
		if (index == S.length) {
			ans.add((List<Integer>) list.clone());
			return;
		}
		list.add(S[index]);
		recurse(S, index + 1, list);
		list.remove(list.size() - 1);
		recurse(S, index + 1, list);
	}
    
	public static void main(String[] args) {
		Subsets sol_costly = new Subsets();
		System.out.println(sol_costly.subsets_costly(new int[] {1, 2, 3}));
		
		Subsets sol_efficient = new Subsets();
		System.out.println(sol_efficient.subsets(new int[] {1, 2, 3}));	
		System.out.println(sol_efficient.subsets(new int[] {4, 1, 0}));	
	}
}
