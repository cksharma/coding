package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParentheses {
	
	private Set <String> set;
	private Set <String> tem;
	public List<String> generateParenthesis(int n) {
		this.set = new HashSet<>();
		this.tem = new HashSet<>();
		
		List <String> list = new ArrayList <>();
		if (n == 0) return list;
		recurse(n, "()");		
		for (String item : set) {
			list.add(item);
		}
		return list;
	}
	
	private void recurse(int n, String result) {
		if (result.length() == 2 * n) {
			set.add(result);
			return;
		}
		if (set.contains(result)) {
			return; 
		}
		if (tem.contains(result) == false) {
			for (int i = 0; i < result.length(); i++) {
				String pre = result.substring(0, i + 1);
				String pos = result.substring(i + 1);
				recurse(n, "(" + pre + ")" + pos);
				recurse(n, "()" + result);
				recurse(n, result + "()");
				tem.add(result);
			}
		}
	}
	
	public static void main(String[] args) {
		GenerateParentheses sol = new GenerateParentheses();
		System.out.println(sol.generateParenthesis(3));
		System.out.println(sol.generateParenthesis(4));
		System.out.println(new HashSet<>(Arrays.asList("(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()")));
	}
}
