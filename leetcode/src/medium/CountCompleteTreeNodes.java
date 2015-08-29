package medium;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
} 

public class CountCompleteTreeNodes {
	
	public int countNodes(TreeNode root) {
    	if (root == null) return 0;
    	//System.out.println("I am right now in " + root.val );
    	if (root.left == null && root.right == null)   	return 1;
    	if (root.left != null && root.right == null) 	return 2;
    	int lHeight = getHeight(root.left);
    	int rHeight = getHeight(root.right);

    	if (lHeight == rHeight) {
    		//System.out.println("Left height = " + lHeight);
    		int result = 1 + (1 << lHeight) + countNodes(root.right) - 1;
    		//System.out.println("I am returning " + result + " from " + root.val);
    		return result;
    	} else {
    		//System.out.println("Right height = " + rHeight);
    		int result = 1 + (1 << rHeight) + countNodes(root.left) - 1;
    		//System.out.println("I am returning " + result + " from " + root.val);
    		return result;
    	}
    }

    public int getHeight(TreeNode root) {
    	int ans = 0;
    	while (root != null) {
    		ans++;
    		root = root.left;
    	}
    	return ans;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		CountCompleteTreeNodes sol = new CountCompleteTreeNodes();
		int ans = sol.countNodes(root);
		System.out.println(ans);
	}
}