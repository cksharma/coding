package medium;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    static Map <Integer, Character> map = new HashMap<>();
    static {
    	map.put(1, 'I');
    	map.put(5, 'V');
    	map.put(10, 'X');
    	map.put(50, 'L');
    	map.put(100, 'C');
    	map.put(500, 'D');
    	map.put(1000, 'M');
    }
    
    static Map <Integer, Integer> closeMap = new HashMap <>();
    static {
    	closeMap.put(1, 1);
    	closeMap.put(2, 1);
    	closeMap.put(3, 1);
    	closeMap.put(4, 5);
    	closeMap.put(5, 5);
    	closeMap.put(6, 5);
    	closeMap.put(7, 5);
    	closeMap.put(8, 5);
    	closeMap.put(9, 10);
    }
    
    private String calculateRoman(int n, int factor) {
    	if (n == 0) return "";
    	StringBuilder sb = new StringBuilder();
    	int digit = n / factor;
    	int res = closeMap.get(digit);
    	int k = res * factor;
    	sb.append(map.get(k));
    	if (k > n) {
    		sb.insert(0, map.get(k - n));
    	} else if (k < n) {
    		for (int r = 0; r < (n - k) / factor; r++) {
    			sb.append(map.get(factor));
    		}
    	}
    	return sb.toString();
    }
    
	public String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		int factor = 1;
		while (num > 0) {
			int res = (num % 10) * factor;
			sb.insert(0, calculateRoman(res, factor));
			factor *= 10;
			num /= 10;
		}		
		return sb.toString();
    }
	public static void main(String[] args) {
		IntegerToRoman sol = new IntegerToRoman();
		//System.out.println(sol.intToRoman(84));
		//System.out.println(sol.intToRoman(94));
		//System.out.println(sol.intToRoman(49));
		//System.out.println(sol.intToRoman(8));
		System.out.println(sol.intToRoman(3999));
		
	}
}
