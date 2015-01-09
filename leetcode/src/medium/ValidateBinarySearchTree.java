package medium;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return validateBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    
    private boolean validateBST(TreeNode root, long leftMax, long rightMin) {
    	if (root == null) return true;
    	long val = root.val;
    	if (val > leftMax || val < rightMin) return false;  

    	boolean lft = validateBST(root.left, val - 1, rightMin);
    	boolean rht = validateBST(root.right, leftMax, val + 1);
    	return lft && rht;
    }
    
    public static void main(String[] args) {
    	
    	ValidateBinarySearchTree sol = new ValidateBinarySearchTree();    	
    	
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(8);
		
		System.out.println(sol.isValidBST(root));
		
		root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(10);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(11);
		System.out.println(sol.isValidBST(root));
		
		root = new TreeNode(1);
		root.left = new TreeNode(1);
		System.out.println(sol.isValidBST(root));
		
		root = new TreeNode(-2147483648);
		root.left = new TreeNode(-2147483648);
		System.out.println(sol.isValidBST(root));
	}
}
