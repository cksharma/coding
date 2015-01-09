package medium;

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		return val + "";
	}
}

public class PopulatingNextRightPointersInEachNode {
	public void connect(TreeLinkNode root) {
		recurse(root, null, false);
	}

	private void recurse(TreeLinkNode root, TreeLinkNode parent, boolean isLeft) {
		if (root == null) return;
		
		if (isLeft && parent != null) {
			root.next = parent.right;
		}
		if (!isLeft && parent != null && parent.next != null) {
			root.next = parent.next.left;
		}
		
		recurse(root.left, root, true);
		
		recurse(root.right, root, false);
	}
	
	private void printTreeLinkNode(TreeLinkNode root) {
		if (root == null) return;
		System.out.println(root.val + " => " + root.next);
		printTreeLinkNode(root.left);
		printTreeLinkNode(root.right);	
	}
	
	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		root.left.left = new TreeLinkNode(4);
		root.left.right = new TreeLinkNode(5);
		root.right.left = new TreeLinkNode(6);
		root.right.right = new TreeLinkNode(7);
		
		PopulatingNextRightPointersInEachNode sol = new PopulatingNextRightPointersInEachNode();
		sol.connect(root);
		sol.printTreeLinkNode(root);
	}
}
