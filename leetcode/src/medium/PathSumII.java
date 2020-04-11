package medium;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
	List <List <Integer>> ans;
	int sum;
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		this.ans = new ArrayList <>();
		this.sum = sum;
		
		List <Integer> lst = new ArrayList <>();
		recurse(root, 0, 0, lst);
		return ans;
	}

	private void recurse(TreeNode root, int runningSum, int height, List<Integer> lst) {
		if (root == null) return;
		
		if (lst.size() > height) {
			lst.set(height, root.val);
		} else {
			lst.add(root.val);
		}
		
		if (root.left == null && root.right == null) {
			
			if (runningSum + root.val == sum) {
				List <Integer> kk = new ArrayList <>();
				for (int k = 0; k < height + 1; k++) {
					kk.add(lst.get(k));
				}
				ans.add(kk);
			}
		}
		
		recurse(root.left, runningSum + root.val, height + 1, lst);
		recurse(root.right, runningSum + root.val, height + 1, lst);
	}
	
	public static void main(String[] args) {
		PathSumII sol = new PathSumII();
		
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
   		
		sol.pathSum(root, 22);
		System.out.println(sol.ans);
	}
}