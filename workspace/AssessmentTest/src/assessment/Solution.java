package assessment;

class Tree {
	public int x;
	public Tree l;
	public Tree r;
	Tree(int x) {
		this.x = x;
	}
}
class Solution {
    
	int ans = 0; 
    
    private int recurse(Tree T, boolean isLeft) {
    	if (T == null) return -1;
    	if (T.l == null && T.r == null) return 0;
    	int left = 1 + recurse(T.l, true);
    	ans = Math.max(ans, left);
    	int right = 1 + recurse(T.r, false);
    	ans = Math.max(ans, right);	
    	if (isLeft) return left;
    	return right;
    }
    
	public int solution(Tree T) {
        // write your code in Java SE 8
		if (T == null) return -1;
    	recurse(T, false);
    	return ans;
    }
    
    public static void main(String[] args) {
		Solution sol = new Solution();
		Tree tree = new Tree(5);
		tree.l = new Tree(3);
		tree.r = new Tree(10);
		tree.r.l = new Tree(12);
		tree.r.l.l = new Tree(21);
		tree.r.l.r = new Tree(20);
		tree.r.r = new Tree(15);
		tree.r.r.r = new Tree(14);
		
		tree = new Tree(1);
		tree.l = new Tree(2);
		tree.l.r = new Tree(3);
		tree.l.r.l = new Tree(3);
		tree.l.r.l.l = new Tree(3);
		tree.l.r.l.l.l = new Tree(5);
		
		System.out.println(sol.solution(null));
	}
}

//3rd Problem
/*class Solution {
    int solution(int[] A) {
        int n = A.length;
        int i = n - 1;
        int result = -1;
        int k = 0, maximal = 0;
        while (i > 0) {
            if (A[i] == 1) {
                k = k + 1;
                if (k >= maximal) {
                    maximal = k;
                    result = i;
                }	
            }
            else
                k = 0;
            i = i - 1;
        }
        if (A[i] == 1 && k + 1 >= maximal)
            result = 0;
        return result;
    }
    public static void main(String[] args) {
		Solution sol = new Solution();
		//System.out.println(sol.solution(new int[]{0, 1, 1, 1, 0, 1, 1, 1, 0, 1}));
		//System.out.println(sol.solution(new int[]{1, 1, 1, 1, 0, 1, 1, 1, 0, 1}));
		//System.out.println(sol.solution(new int[]{1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1}));
		System.out.println(sol.solution(new int[]{0, 0, 0, 1}));
		//System.out.println(sol.solution(new int[]{0, 1, 0, 0}));
		System.out.println(sol.solution(new int[]{0, 1, 0, 1, 0, 1, 0, 1, 1}));
	}
}
*/



// 2nd Problem
/*
import java.util.Arrays;
class Solution {
	public int solution(int[] A) {
		// write your code in Java SE 8
		int ans = 0;
			
		Arrays.sort(A);
		for (int i = 1; i < A.length; i++) {
			if (A[i] == A[i - 1]) continue;
			int sum = A[i] + A[i - 1];
			int mid1 = sum / 2;
			int mid2 = sum / 2 + 1;
			ans = Math.max(ans, Math.min(Math.abs(mid1 - A[i]), Math.abs(mid1 - A[i - 1])));
			ans = Math.max(ans, Math.min(Math.abs(mid2 - A[i]), Math.abs(mid2 - A[i - 1])));			
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		int[] arr = {10, 0, 8, 2, -1, 12, 11, 3};
		arr = new int[] {-1, -2, -3, -4, -5, -10};
		System.out.println(sol.solution(arr));
	}
}*/
