package medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	
    public List<Integer> spiralOrder(int[][] matrix) {
    	List <Integer> ans = new ArrayList <>();
        if (matrix == null || matrix.length == 0) return ans;
    	int n = matrix.length, m = matrix[0].length;
    	
    	int x1 = 0, y1 = 0;
    	int x2 = n - 1, y2 = m - 1;
    	
    	while (x1 <= x2 && y1 <= y2) {
    		for (int i = x1; i <= y2; i++) {
    			ans.add(matrix[x1][i]);
    		}
    		for (int i = x1 + 1; i <= x2; i++) {
    			ans.add(matrix[i][y2]);
    		}
    		for (int i = y2 - 1; i >= x1 && x1 + 1 <= x2; i--) {
    			ans.add(matrix[x2][i]);
    		} 
    		for (int i = x2 - 1; i > y1 && y2 - 1 >= y1; i--) {
    			ans.add(matrix[i][y1]);
    		}    		
    		x1++; y1++;
    		x2--; y2--;
    	}
    	return ans;
    }
    public static void main(String[] args) {
		int[][] matrix = new int[][] {
							{ 1, 2, 3 },
							{ 4, 5, 6 },
							{ 7, 8, 9 },
							{ 10, 11, 12 }
						};	
		SpiralMatrix sol = new SpiralMatrix();
		System.out.println(sol.spiralOrder(matrix));
		System.out.println(sol.spiralOrder(new int[][] {{6,9}}));
	}
}
