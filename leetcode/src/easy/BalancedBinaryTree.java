package easy;
/**
 * Definition for binary tree
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class BalancedBinaryTree {

	boolean balanced = true;

	public boolean isBalanced(TreeNode root) {
		isBalancedHeight(root);
		return balanced;
	}

	private int isBalancedHeight(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		int leftHeight = 1 + isBalancedHeight(root.left);
		int rightHeight = 1 + isBalancedHeight(root.right);
		if (Math.abs(leftHeight - rightHeight) > 1) {
			balanced = false;
		}
		return Math.max(leftHeight, rightHeight);
	}
	
	public static void main(String[] args) {
		BalancedBinaryTree solution = new BalancedBinaryTree();
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		//tree.right = new TreeNode(3);
		tree.left.left = new TreeNode(4);
		//tree.left.left.left = new TreeNode(5);
		System.out.println(solution.isBalanced(tree));
	}
}