package medium;

import java.util.ArrayList;
import java.util.List;


public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        return catalan(n);
    }
    
    private int catalan(int n) {
    	if (n == 0) return 0;
    	
    	int[] dp = new int[n + 1];
    	dp[1] = 1;
    	
    	int[] nume = new int[3];
    	int[] deno = new int[2];
    	
    	for (int i = 2; i <= n; i++) {
    		nume[0] = dp[i - 1];
    		nume[1] = 2 * i - 1;
    		nume[2] = 2 * i;
    		
    		deno[0] = i + 1;
    		deno[1] = i;
    		
    		List <Integer> factors = getAllPrimeFactors(deno[0], deno[1]);    		
    		
    		for (int item : factors) {
    			if (nume[0] % item == 0) {
    				nume[0]  /= item;
    			} else if (nume[1] % item == 0) {
    				nume[1] /= item;
    			} else {
    				nume[2] /= item;
    			}
    		}
    		dp[i] = nume[0] * nume[1] * nume[2];
    	}
    	
    	return dp[n];
    }
    
    private List<Integer> getAllPrimeFactors(int deno1, int deno2) {
    	List <Integer> list = new ArrayList <Integer> ();
    	int[] arr = new int[] {deno1, deno2};
    	for (int item : arr) {
	    	int factor = 2;
	    	while (factor * factor <= item) {
	    		while (item % factor == 0) {
	    			item = item / factor;
	    			list.add(factor);
	    		}	
	    		factor++;
	    	}
	    	if (item > 1) list.add(item);
    	}
    	return list;
	}
    
    public static void main(String[] args) {
		UniqueBinarySearchTrees sol = new UniqueBinarySearchTrees();
		System.out.println(sol.numTrees(1));
		System.out.println(sol.numTrees(0));
		System.out.println(sol.numTrees(2));
		System.out.println(sol.numTrees(3));
		System.out.println(sol.numTrees(4));
		System.out.println(sol.numTrees(5));
		System.out.println(sol.numTrees(6));
		System.out.println(sol.numTrees(7));
		System.out.println(sol.numTrees(8));
		System.out.println(sol.numTrees(9));
		System.out.println(sol.numTrees(10));
		System.out.println(sol.numTrees(12));
		System.out.println(sol.numTrees(13));
		System.out.println(sol.numTrees(14));
		System.out.println(sol.numTrees(15));
		System.out.println(sol.numTrees(16));
		System.out.println(sol.numTrees(17));
		System.out.println(sol.numTrees(18));
		System.out.println(sol.numTrees(19));
	}
}
