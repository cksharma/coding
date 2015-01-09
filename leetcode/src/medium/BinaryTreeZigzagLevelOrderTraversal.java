package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
   
	List <List <Integer>> ans = new ArrayList<List<Integer>>();
	
	private void recurse(TreeNode root, int level) {
		if (root == null) return;
		ans.get(level).add(root.val);
		recurse(root.left, level + 1);
		recurse(root.right, level + 1);
	}
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		int height = getTreeHeight(root);
		for (int i = 0; i < height; i++) {
			ans.add(new ArrayList<>());
		}
		recurse(root, 0);
		boolean reverse = false;
		for (List <Integer> lst : ans) {
			if (reverse)
				Collections.reverse(lst);
			reverse = !reverse;
		}
		return ans;
    }
	
	private int getTreeHeight(TreeNode root) {
		if (root == null) return 0;
		if (root.left == null && root.right == null) return 1;
		int leftHeight = 1 + getTreeHeight(root.left);
		int rightHeight = 1 + getTreeHeight(root.right);
		return Math.max(leftHeight, rightHeight);
	}
	public static void main(String[] args) {
		
		BinaryTreeZigzagLevelOrderTraversal sol = new BinaryTreeZigzagLevelOrderTraversal();
		
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		sol.zigzagLevelOrder(root);
		System.out.println(sol.ans);
	}
}
