package medium;

import java.util.Arrays;

public class SpiralMatrixII {
    
	public int[][] generateMatrix(int n) {
		int[][] ans = new int[n][n];
    	
    	int x1 = 0, y1 = 0;
    	int x2 = n - 1, y2 = n - 1;
    	int cnt = 1;
    	
    	while (x1 <= x2 && y1 <= y2) {
    		for (int i = x1; i <= y2; i++) {
    			ans[x1][i] = cnt++;
    		}
    		for (int i = x1 + 1; i <= x2; i++) {
    			ans[i][y2] = cnt++;
    		}
    		for (int i = y2 - 1; i >= x1 && x1 + 1 <= x2; i--) {
    			ans[x2][i] = cnt++;
    		} 
    		for (int i = x2 - 1; i > y1 && y2 - 1 >= y1; i--) {
    			ans[i][y1] = cnt++;
    		}    		
    		x1++; y1++;
    		x2--; y2--;
    	}
    	return ans;
    }
	
    public static void main(String[] args) {
		SpiralMatrixII sol = new SpiralMatrixII();
		System.out.println(Arrays.deepToString(sol.generateMatrix(3)));
		System.out.println(Arrays.deepToString(sol.generateMatrix(4)));
	}
}
