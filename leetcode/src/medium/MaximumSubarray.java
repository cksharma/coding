package medium;

import java.util.Arrays;

public class MaximumSubarray {
    public int maxSubArray(int[] A) {
        int ans = Integer.MIN_VALUE;
        int runningSum = 0;
        
        ans = Arrays.stream(A).max().getAsInt();
        //for (int item : A) ans = Math.max(ans, item);
        
        for (int item : A) {
        	if (runningSum >= 0 && runningSum + item >= 0) {
        		ans = Math.max(ans, runningSum + item);
        		runningSum += item;
        	} else {
        		runningSum = 0;
        	}
        }        
        return ans;
    }
    
    public static void main(String[] args) {    	
		MaximumSubarray sol = new MaximumSubarray();
		System.out.println(sol.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
	}    
}
