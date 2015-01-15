package medium;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	
    public String largestNumber(int[] num) {
    	Integer[] arr = Arrays.stream(num).boxed().toArray(Integer[]::new);
    	Arrays.sort(arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer f, Integer s) {
				String ff = f + "";
				String ss = s + "";

				String first = ff + ss;
				String secon = ss + ff;
				for (int i = 0; i < first.length(); i++) {
					if (first.charAt(i) < secon.charAt(i)) return 1;
					if (first.charAt(i) > secon.charAt(i)) return -1;
				}
				return 0;
			}    		
    	});
    	String res = "";
    	boolean zeros = true;
    	for (int index = 0; index < arr.length; index++) {
    		if (arr[index] == 0 && zeros) {
    			continue;
    		}	
    		res += arr[index];
    		zeros = false;
    	}    	
    	return res.isEmpty() ? "0" : res;
    }
    
    public static void main(String[] args) {
		LargestNumber sol = new LargestNumber();
		System.out.println(sol.largestNumber(new int[]{3, 30, 34, 5, 9}));
		System.out.println(sol.largestNumber(new int[]{987, 9, 89, 5, 51}));
		System.out.println(sol.largestNumber(new int[]{0, 0}));
		System.out.println(sol.largestNumber(new int[]{824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247}));
	}
}
