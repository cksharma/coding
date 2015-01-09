package medium;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class BSTIterator {

	List <Integer> list = new ArrayList <>();
	int index;
	
	public BSTIterator(TreeNode root) {
		inOrder(root);
    }   
    
	private void inOrder(TreeNode root) {
		if (root == null) return;
		inOrder(root.left);
		list.add(root.val);
		inOrder(root.right);
	}
	
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index < list.size();
    }

    /** @return the next smallest number */
    public int next() {
        return list.get(index++);
    }
    
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(10);
    	root.left = new TreeNode(5);
    	root.left.right = new TreeNode(8);
    	root.left.left = new TreeNode(2);
    	root.right = new TreeNode(15);
    	root.right.left = new TreeNode(12);
    	root.right.right = new TreeNode(17);
    	
    	BSTIterator i = new BSTIterator(root);
    	
    	while (i.hasNext()) System.out.println(i.next());
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */

