package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
	
	List <String> ans;
	
	String digits;
	
	static Map <Character, char[]> map = new HashMap <>();
	{
		map.put('2', new char[] {'a', 'b', 'c'});
		map.put('3', new char[] {'d', 'e', 'f'});
		map.put('4', new char[] {'g', 'h', 'i'});
		map.put('5', new char[] {'j', 'k', 'l'});
		map.put('6', new char[] {'m', 'n', 'o'});
		map.put('7', new char[] {'p', 'q', 'r', 's'});
		map.put('8', new char[] {'t', 'u', 'v'});
		map.put('9', new char[] {'w', 'x', 'y', 'z'});		
	}
	
	public List<String> letterCombinations(String digits) {
		this.digits = digits;
		this.ans = new ArrayList<String>();
		char[] ch = new char[digits.length()];
		recurse(ch, 0);
		return ans;
    }
	
	private void recurse(char[] arr, int index) {
		if (index == digits.length()) {
			ans.add(new String(arr));
			return;
		} 
		char[] kk = map.get(digits.charAt(index));
		for (int j = 0; j < kk.length; j++) {
			arr[index] = kk[j];
			recurse(arr, index + 1);
		}		
	}
	
	public static void main(String[] args) {
		String digits = "23";
		LetterCombinationsOfAPhoneNumber sol = new LetterCombinationsOfAPhoneNumber();
		List <String> ans = sol.letterCombinations(digits);
		System.out.println(ans);
	}
}
