package medium;

public class ConvertSortedArrayToBinarySearchTree {
	private int[] num;
	
	private TreeNode recurse(int from, int to) {
		if (from > to) return null;
		if (from == to) {
			return new TreeNode(num[from]);
		}
		int middle = (from + to) / 2;
		TreeNode root = new TreeNode(num[middle]);
		root.left = recurse(from, middle - 1);
		root.right = recurse(middle + 1, to);
		return root;
	}
	
	public TreeNode sortedArrayToBST(int[] num) {
    	this.num = num;
		return recurse(0, num.length - 1);
    }
    
	public static void main(String[] args) {
		ConvertSortedArrayToBinarySearchTree sol = new ConvertSortedArrayToBinarySearchTree();
		int[] num = new int[] {1, 2, 3, 4, 5, 6, 7};
		TreeNode root = sol.sortedArrayToBST(num);
		sol.printBST(root);
	}
	
	private void printBST(TreeNode root) {
		if (root == null) return;
		printBST(root.left);
		System.out.print(root.val + " -> ");
		printBST(root.right);
	}
}
