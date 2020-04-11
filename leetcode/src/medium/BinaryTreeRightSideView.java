package medium;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cksharma on 4/5/15.
 */
public class BinaryTreeRightSideView {
    List <Integer> ans = new ArrayList<>();
    List<List<Integer>> agg = new ArrayList<>();

    private void recurse(int level, TreeNode root) {
        if (root == null) return;
        if (level == agg.size()) {
            agg.add(new ArrayList<>());
        }

        agg.get(level).add(root.val);

        recurse(level + 1, root.left);
        recurse(level + 1, root.right);

    }

    public List<Integer> rightSideView(TreeNode root) {

        recurse(0, root);
        for (List <Integer> ls : agg) {
            ans.add(ls.get(ls.size() - 1));
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        BinaryTreeRightSideView sol = new BinaryTreeRightSideView();
        sol.rightSideView(root);
        System.out.println(sol.ans);

        BinaryTreeRightSideView sol1 = new BinaryTreeRightSideView();
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        sol1.rightSideView(root);
        System.out.println(sol1.ans);
    }
}
