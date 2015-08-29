package medium;

/**
 * Created by cksharma on 8/18/15.
 */

class TreeNodeKth {
    int val;
    int pos;
    TreeNodeKth left;
    TreeNodeKth right;

    TreeNodeKth(int x) {
        val = x;
    }
}

public class KthSmallestElementInBST {

    public void copyTreeNode(TreeNode root, TreeNodeKth head) {
        if (root == null) return;

        if (root.left != null) {
            head.left = new TreeNodeKth(root.left.val);
            copyTreeNode(root.left, head.left);
        }
        if (root.right != null) {
            head.right = new TreeNodeKth(root.right.val);
            copyTreeNode(root.right, head.right);
        }
    }

    public void printTree(TreeNodeKth root) {
        if (root == null) return;
        printTree(root.left);
        System.out.println(root.val + " Rank = " + root.pos);
        printTree(root.right);
    }

    int rank = 1;

    public void rankNodes(TreeNodeKth node) {
        if (node == null) return;

        rankNodes(node.left);
        node.pos = rank++;

        rankNodes(node.right);
    }

    public int getRank(TreeNodeKth root, int k) {
        if (root == null) return 0;
        if (root.pos == k) return root.val;
        if (root.pos < k) return getRank(root.right, k);
        else return getRank(root.left, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        TreeNodeKth nthRoot = new TreeNodeKth(root.val);
        TreeNodeKth cksRoot = nthRoot;
        copyTreeNode(root, nthRoot);
        rankNodes(cksRoot);
        //printTree(cksRoot);
        return getRank(cksRoot, k);
    }

    public static void main(String[] args) {
        KthSmallestElementInBST sol = new KthSmallestElementInBST();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        System.out.println(sol.kthSmallest(root, 2));
    }
}
