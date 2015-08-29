package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cksharma on 8/17/15.
 */


public class BinaryTreePaths {
    int[] arr;
    List<String> list = new ArrayList<>();
    public int getHeight( TreeNode root ) {
        if ( root == null ) return 0;
        int leftHeight  = 1 + getHeight(root.left);
        int rightHeight = 1 + getHeight(root.right);
        return Math.max(leftHeight, rightHeight);
    }

    public void printPath( TreeNode root, int level ) {
        if ( root == null) return;
        arr[level] = root.val;
        if ( root.left == null && root.right == null ) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < level; i++) {
                sb.append(arr[i]).append("->");
            }
            sb.append(arr[level]);
            list.add(sb.toString());
            return;
        }
        printPath( root.left,  level + 1 );
        printPath( root.right, level + 1 );
    }

    public List<String> binaryTreePaths(TreeNode root) {
        int height = getHeight(root);
        arr = new int[height];
        printPath(root, 0);
        return list;
    }

    public static void main(String[] args) {
        TreeNode node   = new TreeNode(1);
        node.left       = new TreeNode(2);
        node.left.right = new TreeNode(5);
        node.right      = new TreeNode(3);

        BinaryTreePaths treePaths = new BinaryTreePaths();
        List<String> ans = treePaths.binaryTreePaths(node);
        System.out.println(ans);
    }
}
