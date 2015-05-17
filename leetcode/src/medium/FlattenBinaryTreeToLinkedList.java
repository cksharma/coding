package medium;

public class FlattenBinaryTreeToLinkedList {
    
	TreeNode prev;
	
	public void flatten(TreeNode root) {
		if (root == null) return;
		recurse(root, root.left, root.right);
    }
	
	private void recurse(TreeNode root, TreeNode left, TreeNode right) {
		if (root == null) return;
		if (prev != null) {
			prev.left = null;
			prev.right = root;
		}
		prev = root;
		if (left != null) {
			recurse(left, left.left, left.right);			
		}
		if (right != null) {
			recurse(right, right.left, right.right);
		}	
	}
	
	private void printLinkedList(TreeNode root) {
		while (root != null) {
			System.out.print(root.val + " => ");
			root = root.right;
		}
	}
	
	public static void main(String[] args) {

     	FlattenBinaryTreeToLinkedList sol = new FlattenBinaryTreeToLinkedList();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		//root.left.right = new TreeNode(4);
		//root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		
		sol.flatten(root);
		sol.printLinkedList(root);
	}
}
