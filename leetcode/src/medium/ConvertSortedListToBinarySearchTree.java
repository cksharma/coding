package medium;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}

    @Override
    public String toString() {
        String ans = "";
        ListNode node = this;
        while (node != null) {
            ans += node.val + " -> ";
            node = node.next;
        }
        return ans;
    }
}

public class ConvertSortedListToBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		return recurse(head, null);
	}

	private TreeNode recurse(ListNode head, ListNode tail) {
		if (head == tail) return null;
		if (head.next == tail) {
			return new TreeNode(head.val);
		}
		ListNode middle = head;
		ListNode fast = head;
		while (fast != tail && fast.next != tail) {
			middle = middle.next;
			fast = fast.next.next;
		}
		TreeNode root = new TreeNode(middle.val);
		root.left = recurse(head, middle);
		root.right = recurse(middle.next, tail);
		return root;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		
		ConvertSortedListToBinarySearchTree sol = new ConvertSortedListToBinarySearchTree();
		TreeNode root = sol.sortedListToBST(head);
		sol.printBST(root);
	}
	
	private void printBST(TreeNode root) {
		if (root == null) return;
		printBST(root.left);
		System.out.print(root.val + " -> ");
		printBST(root.right);
	}
}
