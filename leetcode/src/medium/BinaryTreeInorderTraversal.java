package medium;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    private List <Integer> ans;
	public List<Integer> inorderTraversal(TreeNode root) {
    	this.ans = new ArrayList <>();
    	inorder(root);
    	return ans;
    }
	private void inorder(TreeNode root) {
		if (root == null) return;
		inorder(root.left);
		ans.add(root.val);		
		inorder(root.right);
	}    
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		BinaryTreeInorderTraversal sol = new BinaryTreeInorderTraversal();
		System.out.println(sol.inorderTraversal(root));
	}
}
