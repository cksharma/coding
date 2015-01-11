package medium;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
    	List <Integer> ans = new ArrayList <>();
    	ans.add(0);
    	for (int i = 0; i < n; i++) {
    		for (int j = ans.size() - 1; j >= 0; j--) {
    			ans.add(ans.get(j) + (1 << i));
    		}
    	}
    	return ans;
    }
    
	public static void main(String[] args) {
		GrayCode sol = new GrayCode();
		System.out.println(sol.grayCode(3));
	}
}
