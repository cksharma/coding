package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by cksharma on 11/25/15.
 */
public class BinaryLevelOrderTraversal {

    private List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();
        queue.add(root);
        level.add(0);
        List<Integer> numList = new ArrayList<>();
        numList.add(root.val);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int index = level.poll();
            if (list.size() == index) {
                //numList.add(node.val);
                list.add(numList);
                numList = new ArrayList<>();
            }
            if (node.left != null) {
                queue.add(node.left);
                level.add(index+1);
                numList.add(node.left.val);
            }
            if (node.right != null) {
                queue.add(node.right);
                level.add(index + 1);
                numList.add(node.right.val);
            }
        }
        if (numList.size() > 0) list.add(numList);
        return list;
    }

    public static void main(String[] args) {
        BinaryLevelOrderTraversal sol = new BinaryLevelOrderTraversal();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        System.out.println(sol.levelOrder(node));
    }
}

