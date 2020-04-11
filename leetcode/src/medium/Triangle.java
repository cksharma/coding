package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0)
			return 0;
		int n = triangle.size();
		int[][] arr = new int[n][];
		for (int i = 0; i < n; i++) {
			arr[i] = new int[i + 1];
		}
		arr[0][0] = triangle.get(0).get(0);
		
		for (int row = 1; row < n; row++) {
			int m = triangle.get(row).size();
			for (int col = 0; col < m; col++) {
				if (col == 0) {
					arr[row][col] = arr[row - 1][col] + triangle.get(row).get(col);
				} else if (col == m - 1) {
					arr[row][col] = arr[row - 1][col - 1] + triangle.get(row).get(col);
				} else {
					arr[row][col] = Math.min(arr[row - 1][col - 1], arr[row - 1][col] ) + triangle.get(row).get(col);
				}
			}
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			ans = Math.min(ans, arr[n - 1][i]);
		}
		return ans;
    }
	public static void main(String[] args) {
		
	    Triangle sol = new Triangle();
		List <List<Integer>> lst = new ArrayList<>();
		lst.add(new ArrayList <>(Arrays.asList(2)));
		lst.add(new ArrayList <>(Arrays.asList(3, 4)));
		lst.add(new ArrayList <>(Arrays.asList(6, 5, 7)));
		lst.add(new ArrayList <>(Arrays.asList(4, 1, 8, 3)));
		System.out.println(lst);
		System.out.println(sol.minimumTotal(lst));
	}
	
}
